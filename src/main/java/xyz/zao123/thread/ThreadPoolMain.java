package xyz.zao123.thread;

import java.util.concurrent.*;

public class ThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service = Executors.newScheduledThreadPool(5);


        service.execute(() -> System.out.println("running……"));

        Future<?> submit1 = service.submit(() -> System.out.println("running1……"));
        System.out.println(submit1.get());

        Future<String> submit2 = service.submit(() -> "running2……");
        System.out.println(submit2.get());

        FutureTask<String> futureTask = new FutureTask<>(()->"running");
        Future<?> submit3 = service.submit(futureTask);
        System.out.println(submit3.get());
        System.out.println(futureTask.get());

        Object result = "result";
        Future<Object> submit4 = service.submit(() -> System.out.println(1), result);
        System.out.println(submit4.get());

        service.shutdown();
    }

}
