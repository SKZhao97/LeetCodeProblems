/**
 * 1156. Swap For Longest Repeated Character Substring
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 * July 31st
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int[] chars = new int[26];
        int max = 0;
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
            max = Math.max(max, chars[c - 'a']);
        }
        if (max <= 1) {
            return max;
        }
        max = 1;
        int i = 0, n = text.length();
        while (i < n) {
            int j = i;
            char cur = text.charAt(i);
            while (j < n && text.charAt(j) == cur) {
                j++;
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == cur) {
                k++;
            }
            max = Math.max(max, k - j - 1 == chars[cur - 'a'] ? k - i - 1 : k - i);
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        SwapForLongestRepeatedCharacterSubstring swapForLongestRepeatedCharacterSubstring = new SwapForLongestRepeatedCharacterSubstring();
        String text = "ababa";
        System.out.println(swapForLongestRepeatedCharacterSubstring.maxRepOpt1(text));
    }
}
