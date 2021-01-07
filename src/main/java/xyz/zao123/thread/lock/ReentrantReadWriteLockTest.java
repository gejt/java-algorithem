package xyz.zao123.thread.lock;

/**
 * 它拥有读锁(ReadLock)和写锁(WriteLock)，读锁是一个共享锁，写锁是一个排他锁。
 * 它的特性：
 * 公平性：支持公平锁和非公平锁。默认使用了非公平锁。
 * 可重入：读线程在获取读锁之后能够再次获取读锁。写线程在获取写锁之后能够再次获取写锁，同时也可以获取读锁（锁降级）。
 * 锁降级：先获取写锁，再获取读锁，然后再释放写锁的过程。锁降级是为了保证数据的可见性
 */
public class ReentrantReadWriteLockTest {

}
