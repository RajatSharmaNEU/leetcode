package GFG.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Practice {
    private static class Item {
        int weight;
        int value;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    private static double getMaxPossibleValue(Item[] items, int weight) {
        Arrays.sort(items, (a, b) ->  (b.value * a.weight) - (a.value * b.weight));
        double resultValue = 0.0;

        for (int i = 0; i < items.length; i++) {

            if(items[i].weight < weight) {
                weight = weight - items[i].weight;
                resultValue = resultValue + items[i].value;
            } else {
                resultValue = resultValue +  ((weight * items[i].value) / items[i].weight);
                break;
            }

        }
        return resultValue;
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(10, 60), // 6
                new Item(40, 40), // 1
                new Item(20, 100), // 5
                new Item(30, 120), // 4
        };

        System.out.println(getMaxPossibleValue(items, 50));
        // 10 + 20 + (20/30)
        // 60 + 100 + (120 * 20/30) = 240
    }
}
