package xyz.zao123.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 可以看成是一个倒计数器，它允许一个或多个线程等待其他线程完成操作。因此，CountDownLatch 是共享锁。
 * CountDownLatch 的 countDown() 方法将计数器减1，await() 方法会阻塞当前线程直到计数器变为0。
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行…… ……");
        //第一个子线程执行
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        });
        es1.shutdown();

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");

        new Parallellimit().testConcurrent();
    }

    public static class Parallellimit {

        public void testConcurrent() {
            ExecutorService pool = Executors.newCachedThreadPool();
            CountDownLatch cdl = new CountDownLatch(100);
            for (int i = 0; i < 100; i++) {
                CountRunnable runnable = new CountRunnable(cdl);
                pool.execute(runnable);
            }
            pool.shutdown();
        }
    }

    static class CountRunnable implements Runnable {
        private CountDownLatch countDownLatch;

        public CountRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                synchronized (countDownLatch) {
                    /*** 每次减少一个容量*/
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+" thread counts = " + (countDownLatch.getCount()));
                }
                countDownLatch.await();
                System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
