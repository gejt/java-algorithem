package xyz.zao123.thread.lock;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            String s = "t1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 s="+s);
        }).start();

        new Thread(()->{
            String s = "t2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 s="+s);
        }).start();

    }
}
