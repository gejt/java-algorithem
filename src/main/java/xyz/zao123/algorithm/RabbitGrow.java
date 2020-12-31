package xyz.zao123.algorithm;

/**
 * @author gejt
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总对数为多少？
 * 兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class RabbitGrow {
    public static void main(String[] args){
        for(int i=1;i<=20;i++){
            System.out.println(f(i));
        }
    }
    private static int f(int i) {
        if(i==1||i==2){
            return 1;
        }
        return f(i-1)+f(i-2);
    }
}
