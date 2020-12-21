package xyz.zao123.algorithm;

public class DoublePrintTread extends Thread{
    private final static int STEP = 2;

    private String str ;
    private Integer start;

    private Object lock ;

    public DoublePrintTread(String str,Integer start,Object lock){
        this.str = str;
        this.start = start;
        this.lock = lock;
    }


    @Override
    public synchronized void run() {
        int index = start;
        while(index<str.length()){
            synchronized (lock){
                System.out.println(str.charAt(index));
                index = index + STEP;
                lock.notify();
                if(index<str.length()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

}
