package xyz.zao123.thread.lock;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 它拥有读锁(ReadLock)和写锁(WriteLock)，读锁是一个共享锁，写锁是一个排他锁。
 * 它的特性：
 * 公平性：支持公平锁和非公平锁。默认使用了非公平锁。
 * 可重入：读线程在获取读锁之后能够再次获取读锁。写线程在获取写锁之后能够再次获取写锁，同时也可以获取读锁（锁降级）。
 * 锁降级：先获取写锁，再获取读锁，然后再释放写锁的过程。锁降级是为了保证数据的可见性
 */
public class ReentrantReadWriteLockTest {

    static ReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();
    static Lock writeLock = lock.writeLock();

    static LinkedList list = new LinkedList();
    static  int value = 100;

    public static void main(String[] args) {

        Runnable read = ()->read();
        Runnable write = ()->write(new Random().nextInt(100));


        for(int i=0;i<2;i++){
            new Thread(write).start();
        }

        for(int i=0;i<100;i++){
            new Thread(read).start();
        }

    }

    public static void read(){
        readLock.lock();
        try{
            System.out.println("Thread "+ Thread.currentThread().getName()+" read "+ "start");
            Thread.sleep(1000);
            System.out.println("Thread "+ Thread.currentThread().getName()+" read "+ value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public static void write(int v){
        writeLock.lock();
        try{
            System.out.println("Thread "+ Thread.currentThread().getName()+" write "+ "start");
            Thread.sleep(1000);
            value = v;
            System.out.println("Thread "+ Thread.currentThread().getName()+" write "+ v);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }


}
