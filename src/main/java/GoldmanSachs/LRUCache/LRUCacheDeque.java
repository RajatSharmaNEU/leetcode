package GoldmanSachs.LRUCache;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheDeque {
    int capacity;
    Map<Integer, Integer> map;
    Deque<Integer> deque;

    public LRUCacheDeque(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new ArrayDeque<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            if (deque.getFirst() != key) {
                deque.remove(key);
                deque.addFirst(key);
            }
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            deque.remove(key);
        }

        map.put(key, value);
        deque.addFirst(key);

        if(deque.size() > capacity) {
            map.remove(deque.removeLast());

        }
    }

    public static void main(String[] args) {
        LRUCacheDeque lruCache = new LRUCacheDeque(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
