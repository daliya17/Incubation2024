package ProblemSolving.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxProfitDriving {
    public static void main(String[] args) {
        List<Long> pickUp = new ArrayList<>(List.of(11l, 30l, 0l, 21l, 41l, 19l));
        List<Long> dropOff = new ArrayList<>(List.of(20l, 31l, 17l, 22l, 46l, 21l));
        List<Integer> tips = new ArrayList<>(List.of(6, 1, 9, 0, 8, 0));
        System.out.println(maxProfit(pickUp, dropOff, tips));
    }

    public static long maxProfit(List<Long> pickup, List<Long> drop, List<Integer> tips) {
        long maxAmount = 0, maxAmountPassenger = 0;
        int maxIndex = -1;
        List<Long> amounts = new ArrayList<>();
        TreeMap<Long, Pair> map = new TreeMap<>();
        for (int i = 0; i < pickup.size(); i++) {
            map.put(pickup.get(i), new Pair(drop.get(i), tips.get(i)));
        }
        for (int i = 0; i < pickup.size(); i++) {
            amounts.add((drop.get(i) - pickup.get(i)) + tips.get(i));
        }
        for (int i = 0; i < amounts.size(); i++) {
            if (amounts.get(i) > maxAmountPassenger) {
                maxAmountPassenger = amounts.get(i);
                maxIndex = i;
            }
        }
        maxAmount = amounts.get(maxIndex);
        Long prevDrop = drop.get(maxIndex);
        for (Map.Entry<Long, Pair> entry : map.entrySet()) {
            if (entry.getKey() > pickup.get(maxIndex) && entry.getKey() >= prevDrop) {
                maxAmount += (entry.getValue().drop - entry.getKey()) + entry.getValue().tip;
                prevDrop = entry.getValue().drop;
            }
        }
        return maxAmount;

    }

    public static class Pair {
        private Long drop;
        private int tip;

        Pair(Long drop, int tip) {
            this.tip = tip;
            this.drop = drop;
        }
    }
}
