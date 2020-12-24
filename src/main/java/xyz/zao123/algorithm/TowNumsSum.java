package xyz.zao123.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gejt
 * input array=[2,7,5,12] target=9
 * return [0.1]
 */
public class TowNumsSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 5, 12,9};
        int target = 17;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            map.put(i, target - arr[i]);
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (m.getValue()==arr[i]) {
                    System.out.println("[" + m.getKey() + "," + i + "]");
                }

            }
        }



    }
}
