import java.util.Arrays;

/**
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 * June 20th
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
//            if (code < 100) {
//                continue;
//            }
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }


    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        String s = "aab";
        System.out.println(reorganizeString.reorganizeString(s));
    }
}