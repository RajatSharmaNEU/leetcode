package practice;

import java.util.*;

public class LearnCollections {
    public static void learnArray() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void learnList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void learnHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

//        for(String key: map.keySet()) {
//            System.out.println(key);
//        }
//
//        for(Integer value: map.values()) {
//            System.out.println(value);
//        }

        List<String> listFromMap = new ArrayList<>(map.keySet());
        for(String key: listFromMap) {
            System.out.println(key);
        }

    }

    public static void learnHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A");
        set.add("B");

        for(String str: set) {
            System.out.println(str);
        }

        System.out.println(set.contains("C"));

        for (String str: set.toArray(new String[0])) {
            System.out.println(str);
        }

        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Array");
        learnArray();
        System.out.println("List");
        learnList();
        System.out.println("HashMap");
        learnHashMap();
        System.out.println("HashSet");
        learnHashSet();
    }
}
