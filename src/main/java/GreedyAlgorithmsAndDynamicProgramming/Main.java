package GreedyAlgorithmsAndDynamicProgramming;

public class Main {
    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };
        int capacity = 50;

        double maxValue = FractionalKnapsack.getMaxValue(capacity, items);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
