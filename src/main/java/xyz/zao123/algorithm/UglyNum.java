package xyz.zao123.algorithm;

/**
 * 我们把值包含因子 2,3,5的数称作丑数，求按照从小到大顺序的第1500个丑数，
 * 例如6,8都是丑数，但是14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
 */
public class UglyNum {


    public static void main(String[] args) {
        findUglyNum(8);
    }

    /**
     *  输出第k个丑数(因子只有2，3，5)
     *  1 2 3 4 5 6 8 9
     *  其中9是第8个丑数
     */

    private static void findUglyNum(int index) {
        int[] num = new int[index];
        int next = 1;
        num[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;

        while(next<index){
            int num2 = num[index2]*2;
            int num3 = num[index3]*3;
            int num5 = num[index5]*5;

            // 找到最小的丑数
            num[next] = getSuitable(num2,num3,num5);

            //判断是2的丑数还是3的丑数还是5的丑数
            while(num[index2]*2<=num[next]){
                index2++;
            }
            while(num[index3]*3<=num[next]){
                index3++;
            }
            while(num[index5]*5<=num[next]){
                index5++;
            }
            //准备计算下一位丑数
            next++;

        }
        System.out.println(num[index-1]);
    }

    public static int getSuitable(int num2, int num3, int num5){
        int s = num2;
        if(num3<s){
            s = num3;
        }
        if(num5<s){
            s = num5;
        }
        return s;
    }

}
