package xyz.zao123.thread.lock;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    @Test
    public void test(){

        CyclicBarrier barrier = new CyclicBarrier(20,()->{
            System.out.println("人数够了，发车");
        });

        Runnable runnable = ()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        for(int i=0;i<100;i++){
            service.execute(runnable);
        }

        service.shutdown();
    }

}
