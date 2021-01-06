package xyz.zao123.algorithm;

/**
 * 找到数组中出现次数超过一般的元素
 * 例如{1,2,3,2,2,2,5,4,2}
 * 输出2
 */
public class FindNumCountHalfArray {

    public static void main(String[] args) {
        int[] num = {1,2,2,2,2,2,2,4,2,4,6,4,2,6,8,2,7,7};
        System.out.println(moreThanHaft(num));
    }

    private static int moreThanHaft(int[] num) {
        int times = 0;
        int result = -1;
        for(int i=0 ;i<num.length;i++){
            if(times==0){
                result = num[i];
                times ++;
            }
            if(result == num[i]){
                times ++;
            }else{
                times --;
            }

        }
        return result;
    }


}
