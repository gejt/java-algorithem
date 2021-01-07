package xyz.zao123.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        Semaphore semaphore = new Semaphore(3);
        Lock lock = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i=0;i<100;i++){
            service.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" count="+semaphore.getQueueLength());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }


}
