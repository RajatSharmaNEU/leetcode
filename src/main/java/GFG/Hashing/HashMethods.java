package GFG.Hashing;

import java.util.*;
import java.util.stream.Collectors;

public class HashMethods {
    public static void hashSetMethods() {
        HashSet<String> set = new HashSet<>(1);
        set.add("Hello");
        set.add("World");

        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());

        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("World"));

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String item: set) {
            System.out.println(item);
        }

        set.clear();

        System.out.println(set.contains("Hello"));
        System.out.println(set.contains("World"));

        HashSet<String> setFromArray = new HashSet(Arrays.asList("Hash", "Set", "From", "Array", "Set", "From", "Array"));
        System.out.println(setFromArray);
    }

    public static void hashMapMethods() {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Hello", 2);
        map.put("World", 5);

        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println(map.containsKey("Hello"));
        System.out.println(map.containsKey("World"));

        System.out.println(map.containsValue(2));
        System.out.println(map.containsValue(5));

        System.out.println(map.get("Hello"));
        System.out.println(map.get("World"));

        for (Map.Entry <String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for (String entry : map.keySet()) {
            System.out.println(entry);
        }

        for (Integer entry : map.values()) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
//        hashSetMethods();
        hashMapMethods();
    }
}
