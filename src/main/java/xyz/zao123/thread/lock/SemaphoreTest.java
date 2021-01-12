package xyz.zao123.thread.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 可以指定多个线程同时访问某个资源，而 synchronized 和 ReentrantLock 都是一次只允许一个线程访问某个资源。由于 Semaphore 适用于限制访问某些资源的线程数目，因此可以使用它来做限流。
 *
 * Semaphore 并不会实现数据的同步，数据的同步还是需要使用 synchronized、Lock 等实现。
 * 它的特性：
 *
 * 基于 AQS 的共享模式
 * 公平性：支持公平模式和非公平模式。默认使用了非公平模式。
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();

        for(int i = 0;i<1000;i++){
            list.add(new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("线程"+Thread.currentThread().getName()+"执行啊");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            }));
        }

        list.forEach(Thread::start);

        System.out.println("cost time:"+(System.currentTimeMillis()-start)+"ms");
    }

    @Test
    public void test(){
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
