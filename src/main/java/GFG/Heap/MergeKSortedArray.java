package GFG.Heap;

import java.util.*;

public class MergeKSortedArray {
    static class Triplet {
        int value;
        int arrayNumber;
        int position;

        Triplet(int v, int n, int p) {
            this.value = v;
            this.arrayNumber = n;
            this.position = p;
        }
    }

    public static List<Integer> mergeArray(ArrayList<ArrayList<Integer>> sortedArrayList) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet o1, Triplet o2) {
                return o1.value - o2.value ;
            }
        });
        int arrayCount = sortedArrayList.size();

        // first add zero index elements in pq
        for (int i = 0; i < arrayCount; i++) {
            pq.add(new Triplet(sortedArrayList.get(i).get(0), i, 0));
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        while (!pq.isEmpty()) {
            Triplet currTop = pq.poll();
            resultList.add(currTop.value);

            int currArrayNumber = currTop.arrayNumber;
            int currPosition = currTop.position;

            if(currPosition + 1 < sortedArrayList.get(currArrayNumber).size()) {
                Triplet newElement = new Triplet(
                        sortedArrayList.get(currArrayNumber).get(currPosition + 1),
                        currArrayNumber,
                        currArrayNumber + 1);
                pq.add(newElement);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> sortedArrayList = new ArrayList<>();
        sortedArrayList.add(new ArrayList<>(Arrays.asList(5, 10)));
        sortedArrayList.add(new ArrayList<>(Arrays.asList(4, 9)));
        sortedArrayList.add(new ArrayList<>(Arrays.asList(6)));

        List<Integer> result = mergeArray(sortedArrayList);
        result.stream().forEach(System.out::println);
    }
}