package pack;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

    private static class Item {
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }


    public static int maxProfit(int[] weights, int[] profits, int capacity) {
        Item[] items = new Item[weights.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(weights[i], profits[i]);
        }

        return maxProfit(items, 0, capacity);
    }


    private static int maxProfit(Item[] items, int start, int capacity) {
        for (int i = start; i < items.length; i++) {
            if (items[i].weight > capacity) {
                continue;
            } else {
                int profitWithMax = items[i].profit + maxProfit(items, i + 1, capacity - items[i].weight);
                int profitWithoutMax = maxProfit(items, i + 1, capacity);
                return   Math.max(profitWithMax, profitWithoutMax);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120, 150, 200, 300, 500, 1000, 1100, 1211 };
        int wt[] = new int[] { 10, 20, 30, 40, 50, 80, 100, 300, 350, 353 };
        int W = 1000;

        System.out.println(maxProfit(wt, val, W));
    }
}
