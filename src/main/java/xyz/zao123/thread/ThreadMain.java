package xyz.zao123.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author gejt
 */
public class ThreadMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new MyThread().start();

        new Thread(new MyRunnable()).start();

        new Thread(() -> {
            System.out.println("running");
        }).start();

        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        String result = "I'm resulr!!";
        FutureTask<String> futureTask1 = new FutureTask<String>(new Runnable() {
            @Override
            public void run() {
                System.out.println("running aaa……");
            }
        }, result);

//        futureTask1.run();
        new Thread(futureTask1).start();

        System.out.println(futureTask1.get());

        Thread.sleep(10000L);

    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getClass().getName() + " is running");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(this.getClass().getName() + " is running");
        }
    }

    public static class MyCallable implements Callable {

        @Override
        public String call() throws Exception {
            return "" + this.getClass().getName() + " is running";
        }
    }
}
