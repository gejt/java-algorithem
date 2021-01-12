package xyz.zao123.thread.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            System.out.println("t1 running");

            LockSupport.park();

            System.out.println("t1 continue");
        });

        Thread t2 = new Thread(()->{
            System.out.println("t2 running");

            LockSupport.unpark(t1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 continue");
        });

        t1.start();
        t2.start();

    }

}
