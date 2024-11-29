package GFG.Hashing.Neetcode;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs) {
            res.append(str.length()).append("#").append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            i = j+1;
            j = i + length;

            String word = str.substring(i, j);
            res.add(word);

            i = j;
        }

        return res;
    }
}
