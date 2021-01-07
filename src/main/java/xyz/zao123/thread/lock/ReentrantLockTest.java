package xyz.zao123.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 是一个独占/排他锁。相对于 synchronized，它更加灵活。但是需要自己写出加锁和解锁的过程。它的灵活性在于它拥有很多特性。
 * ReentrantLock 需要显示地进行释放锁。特别是在程序异常时，synchronized 会自动释放锁，而 ReentrantLock 并不会自动释放锁，所以必须在 finally 中进行释放锁。
 * 公平性：支持公平锁和非公平锁。默认使用了非公平锁。
 * 可重入
 * 可中断：相对于 synchronized，它是可中断的锁，能够对中断作出响应。
 * 超时机制：超时后不能获得锁，因此不会造成死锁。
 * ReentrantLock 是很多类的基础，例如 jdk1.7 ConcurrentHashMap 内部使用的 Segment 就是继承 ReentrantLock，CopyOnWriteArrayList 也使用了 ReentrantLock。
 *
 * ReentrantLock主要利用CAS+AQS队列来实现。
 * AQS使用一个FIFO的队列表示排队等待锁的线程，队列头节点称作“哨兵节点”或者“哑节点”，它不与任何线程关联。其他的节点与等待线程关联，每个节点维护一个等待状态waitStatus
 * ReentrantLock的基本实现可以概括为：先通过CAS尝试获取锁。如果此时已经有线程占据了锁，那就加入AQS队列并且被挂起。当锁被释放之后，排在CLH队列队首的线程会被唤醒，然后CAS再次尝试获取锁。在这个时候，如果：
 * 非公平锁：如果同时还有另一个线程进来尝试获取，那么有可能会让这个线程抢先获取；
 * 公平锁：如果同时还有另一个线程进来尝试获取，当它发现自己不是在队首的话，就会排到队尾，由队首的线程获取到锁。
 */

public class ReentrantLockTest {

    public static void main(String[] args) {
        //默认非公平锁
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try {
            //TO do you business
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }


        try {
            lock.lockInterruptibly();
            try {
                //TO do you business
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lock.tryLock()) {
            try {

                //do something here
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }


        //公平锁
        ReentrantLock fairLock = new ReentrantLock(true);


    }

    /**
     * ReentrantLock中另一个重要的应用就是Condition，Condition是Lock上的一个条件
     * ，可以多次newCondition()获得多个条件，Condition可用于线程间通信
     * ，通过Condition能够更加精细的控制多线程的休眠与唤醒
     * ，而且在粒度和性能上都优于Object的通信方法（wait、notify 和 notifyAll）；
     */

    class BoundedBuffer {
        final Lock lock = new ReentrantLock();//锁对象
        final Condition notFull = lock.newCondition();//写线程条件
        final Condition notEmpty = lock.newCondition();//读线程条件

        final Object[] items = new Object[100];//缓存队列
        int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)//如果队列满了
                    notFull.await();//阻塞写线程
                items[putptr] = x;//赋值
                if (++putptr == items.length) putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0
                ++count;//个数++
                notEmpty.signal();//唤醒读线程
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)//如果队列为空
                    notEmpty.await();//阻塞读线程
                Object x = items[takeptr];//取值
                if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
                --count;//个数--
                notFull.signal();//唤醒写线程
                return x;
            } finally {
                lock.unlock();
            }
        }
    }

}
