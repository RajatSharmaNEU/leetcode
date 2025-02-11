package Oracle;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        int[] cache = new int[26];

        for (String str : strs) {
            Arrays.fill(cache, 0);

            for (char ch : str.toCharArray()) {
                cache[ch - 'a']++;
            }

            String key = "#" + Arrays.toString(cache);

            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.put(key, map.get(key)).add(str);

        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> list: map.values()) {
            result.add(list);
        }

        return result;

    }
}
