package xyz.zao123.thread.lock;

/**
 * 对象锁  类锁  私有锁  (所有锁都是锁对象)
 *      * 对象锁锁具有可重入性。
 *      * 当一个线程获得了某个对象的对象锁，则该线程仍然可以调用其他任何需要该对象锁的 synchronized 方法或 synchronized(this) 同步代码块。
 *      * 当一个线程访问某个对象的一个 synchronized(this) 同步代码块时，其他线程对该对象中所有其它 synchronized(this) 同步代码块的访问将被阻塞，因为访问的是同一个对象锁。
 *      * 每个类只有一个类锁，但是类可以实例化成对象，因此每一个对象对应一个对象锁。
 *      * 类锁和对象锁不会产生竞争。
 *      * 私有锁和对象锁也不会产生竞争。
 *      * 使用私有锁可以减小锁的细粒度，减少由锁产生的开销
 */
public class SynchronizedTest {


    /**
     * 对象锁：使用 synchronized 修饰非静态的方法以及 synchronized(this) 同步代码块使用的锁是对象锁。

     */

    public synchronized void objectLock1(){
        System.out.println("objectLock1");
    }

    public void objectLock2(){
        synchronized (this){
            System.out.println("objectLock2");
        }
    }

    /**
     * 类锁：使用 synchronized 修饰静态的方法以及 synchronized(class) 同步代码块使用的锁是类锁。
     */

    public synchronized static void classLock1(){
        System.out.println("classLock1");
    }

    public void classLock2(){
        synchronized (SynchronizedTest.class){
            System.out.println("classLock2");
        }
    }

    /**
     * 私有锁：由私有锁实现的等待/通知机制：
     */
    public void privateLock(){
        Object lock = new Object();
        synchronized (lock){
            try {
                //通知其他线程争取锁
                lock.notify();
//                lock.notifyAll();
                //自己进入WATTING 状态
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
