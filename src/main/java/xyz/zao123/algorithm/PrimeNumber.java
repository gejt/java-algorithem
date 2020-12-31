package xyz.zao123.algorithm;

/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
 * 则表明此数不是素数，反之是素数。
 */
public class PrimeNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            if (isPrimeNumber1(i)) {
                System.out.println(i);
            }
        }
    }

    /***
     * 根据定义所有素数都是大于1的自然数，那么小于等于1的数都没有素数的概念。
     * 数字2只有1和2两个因数，因而必定是素数，其他数字x只要判定从2到x-1都无法被它整除，就证明改数字是素数。
     * @param x
     * @return
     */

    private static boolean isPrimeNumber1(int x) {
        for (int i = 2; i < x; i++){
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 仔细思考就会发现，其实数字x的因数分成两大部分，
     * 一部分是小于x的平方根，另外一部分大于x的平方根，
     * 小于平方根和大于平方根的部分是一一对应的，
     * 因而可以只判断从2到平方根的数字是否都能被整除即可。
     * @param x
     * @return
     */
    private static boolean isPrimeNumber2(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
