package xyz.zao123.algorithm;

/**
 * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 * 利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class NarcissisticNum {

    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            if (shuixianhua(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isNarcissisticNum(int x) {

        int i = x / 100;
        int j = (x - i * 100) / 10;
        int k = x - i * 100 - j * 10;

        if (x == i * i * i + j * j * j + k * k * k) {
            return true;
        }
        return false;
    }

    public static boolean shuixianhua(int x) {

        int i = 0, j = 0, k = 0;

        i = x / 100;

        j = (x % 100) / 10;

        k = x % 10;

        if (x == i * i * i + j * j * j + k * k * k) {
            return true;
        } else {
            return false;

        }

    }
}
