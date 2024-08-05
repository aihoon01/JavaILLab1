package GreedyAlgorithmsAndDynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static double getMaxValue(int capacity, Item[] items) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(
                        o1.getValue()/o1.getWeight(),
                        o2.getValue()/o2.getWeight()
                        );
            }
        });

        double totalValue = 0.0;
        int remainingWeight = capacity;

        for (Item item : items) {
            if (item.getWeight() <= remainingWeight) {
                // If the item can be added fully
                totalValue += item.getValue();
                remainingWeight -= item.getWeight();
            } else {
                // If the item cannot be added fully, add fractional part
                totalValue += item.getValue() * ((double) remainingWeight / item.getWeight());
                break;  // Knapsack is full
            }
        }
        return totalValue;
    }
}
