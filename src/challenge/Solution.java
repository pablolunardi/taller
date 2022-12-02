package challenge;

import java.util.*;

public class Solution {

    public static void main(String ... args) {
        Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 0);
        registerStatus.put(2, 0);
        registerStatus.put(5, 3);
        registerStatus.put(10, 50);
        registerStatus.put(50, 2);


        boolean result = canIGiveChange(registerStatus, 600, 67);
        System.out.printf("Result " + result);

    }

    public static boolean canIGiveChange(Map<Integer,Integer> registerStatus, Integer customerPayment, Integer productCost) {
        int changeNeeded = customerPayment - productCost;

        Map<Integer, Integer> sortedRegisterStatus = new TreeMap<>(Collections.reverseOrder());
        sortedRegisterStatus.putAll(registerStatus);

        int sum = 0;
        for (Map.Entry<Integer, Integer> bill : sortedRegisterStatus.entrySet()) {

            if (bill.getKey() == changeNeeded) {
                return true;
            }

            if (bill.getKey() < changeNeeded) {
                for (int i = bill.getValue(); i > 0; i--) {

                    if ((sum + bill.getKey()) <= changeNeeded) {
                        sum += bill.getKey();
                    }

                    if (sum == changeNeeded) {
                        return true;
                    }
                }
            }

            if (sum == changeNeeded) {
                return true;
            }
        }
        return false;
    }


}
