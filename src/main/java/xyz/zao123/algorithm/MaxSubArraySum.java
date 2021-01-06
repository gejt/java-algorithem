package xyz.zao123.algorithm;

/**
 * 求子数组的和的最大值
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] num = {1,-2,3,10,-4,7,2,-5};
        //int[] num = {1,-2,3,10,-4,10,2,-5};
        System.out.println(maxSum(num));
    }

    private static int maxSum(int[] num) {
        int curSum = 0;
        int curMaxSum = -99999999;
        int start = 0;
        int end = 0;

        for(int i=0;i<num.length;i++){
            if(curSum<=0){
                curSum = num[i];
                start = i;
            }
            else{
                curSum += num[i];
            }
            if(curSum>curMaxSum){
                curMaxSum = curSum;
                end = i;
            }
        }
        for(int i = start;i<=end;i++){
            System.out.println(num[i]);
        }
        return curMaxSum;
    }
}
