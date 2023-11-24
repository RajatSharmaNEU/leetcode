package OA.tiktok;

// Cache used LRU LeastRecentlyUsed replacement policy - when cache is full, delete LRU and insert a new value
// Determine minimum cache capacity require to ensure at least K requests hit the cache else return -1.

// n = request length
// request = ["Item1", "Item1", "Item1", "Item1", "Item1"]
// k = cache hit required

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinuimumCacheCapacity {
    private int calculateMinCache(int n, String[] requests, int k) {
        int cacheSize = 1;
        int cacheHit = 0;
        HashMap<String, Integer> cache = new HashMap<>();

        while (cacheHit < k) {
            // initially clear the cache
            cache.clear();
            Queue<String> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String currRequest = requests[i];
                if (cache.size() < cacheSize) {
                    cache.put(currRequest, 1);
                    queue.add(currRequest);
                } else {
                    if (cache.containsKey(requests[i])) {
                        cacheHit++;
                    }
                    String leastRecentRequest = queue.poll();
                    cache.remove(leastRecentRequest);
                    cache.put(currRequest, 1);
                    queue.add(currRequest);
                }
            }

            cacheSize++;
        }

        return cacheSize - 1;
    }

    public static void main(String[] args) {
        String[] requests1 = new String[]{"Item1", "Item1", "Item3", "Item1", "Item3"};
        String[] requests2 = new String[]{"Item3", "Item2", "Item1", "Item2", "Item1"};
        String[] requests3 = new String[]{"item3", "item4", "item2", "item6", "item4", "item3", "item7", "item4", "item3", "item6", "item3", "item4", "item8", "item4", "item6"};

        int k = 1;

        MinuimumCacheCapacity minuimumCacheCapacity = new MinuimumCacheCapacity();
        int result1 = minuimumCacheCapacity.calculateMinCache(5, requests1, 1);
        System.err.println(result1 == 1 ? "Passed" : "Failed");

        int result2 = minuimumCacheCapacity.calculateMinCache(5, requests2, 1);
        System.err.println(result2 == 2 ? "Passed" : "Failed");

        int result3 = minuimumCacheCapacity.calculateMinCache(15, requests3, 6);
        System.err.println(result3 == 3 ? "Passed" : "Failed");
    }
}
