import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * June 26th
 */
public class FirstUniqueCharacterInAString {
//    public int firstUniqChar(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        List<Character> list = new LinkedList<>();
//        for (char ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//            list.add(ch);
//        }
//
//        for (int k = 0; k < list.size(); k++) {
//            if (map.get(list.get(k)) == 1) {
//                return k;
//            }
//        }
//        return -1;
//    }
    public int firstUniqChar(String s) {
        int[] chars =  new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        String s = "leetcode";
        System.out.println(firstUniqueCharacterInAString.firstUniqChar(s));
    }
}
