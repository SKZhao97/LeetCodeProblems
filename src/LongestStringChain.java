import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/
 * June 22nd
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, -1);
        }

        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(max, helper(map, word));
        }
        return max;
    }

    public int helper(Map<String, Integer> map, String word) {
        if (map.get(word) != -1) {
            return map.get(word);
        }

        map.put(word, 1);
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            if (map.containsKey(sb.toString())) {
                int parent = helper(map, sb.toString());
                map.put(word, Math.max(map.get(word), parent + 1));
            }

            sb.insert(i, word.charAt(i));
        }
        return map.get(word);
    }

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        String[] inputs = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStringChain.longestStrChain(inputs));
    }
}
