package xyz.zao123.algorithm;

/**
 * 双线程交替打印出数字和字母 例如：A1B2C3D4E5
 * @author  gejt
 * @date 20201221
 */
public class TestDoublePrint {

    public static void main(String[] args){
        String STR = "A1B2C3D4E5";
        Object lock = new Object();
        DoublePrintTread thread1 = new DoublePrintTread(STR,0,lock);
        DoublePrintTread thread2 = new DoublePrintTread(STR,1,lock);
        thread1.start();
        thread2.start();
    }
}
