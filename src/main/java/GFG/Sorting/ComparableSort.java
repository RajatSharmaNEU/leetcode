package GFG.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableSort implements Comparable<ComparableSort> {
    int x;
    int y;

    ComparableSort(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(ComparableSort p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }

    public static void main(String[] args) {
        List<ComparableSort> list = new ArrayList<>();
        list.add(new ComparableSort(10, 10));
        list.add(new ComparableSort(5, 10));
        list.add(new ComparableSort(2, 20));
        list.add(new ComparableSort(5, 15));

        Collections.sort(list);
        for (ComparableSort p : list) {
            System.out.println(p.x + " - " + p.y);
        }
    }
}
