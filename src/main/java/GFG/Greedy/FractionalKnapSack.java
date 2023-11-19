package GFG.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    private static class Item {
        int weight;
        int value;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    private double getMaxPossibleValue(Item[] items, int weight) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                 // return (o2.value/o2.weight) - (o1.value/o1.weight); // we need max first ~ decreasing order
                return (o1.weight * o2.value) - (o2.weight * o1.value);
            }
        });

        double result = 0.0;

        for (int i = 0; i < items.length; i++) {
            if(items[i].weight <= weight) {
                result = result + items[i].value;
                weight = weight - items[i].weight;
            } else {
                System.out.println(weight);
                System.out.println(items[i].weight);
                result = result + ((items[i].value * weight) / items[i].weight);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(10, 60), // 6
                new Item(40, 40), // 1
                new Item(20, 100), // 5
                new Item(30, 120), // 4
        };

        FractionalKnapSack fractionalKnapSack = new FractionalKnapSack();
        System.out.println(fractionalKnapSack.getMaxPossibleValue(items, 50));
        // 10 + 20 + (20/30)
        // 60 + 100 + (120 * 20/30) = 240
    }
}
