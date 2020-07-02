import java.util.*;

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 * July 2nd
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        boolean res = true;
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(strs[i])) {
                    res = false;
                    break;
                }
                map.put(pattern.charAt(i), strs[i]);
                set.add(strs[i]);
            }
            String temp = map.get(pattern.charAt(i));
            if (!temp.equals(strs[i])) {
                res = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }
}
