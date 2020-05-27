/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/discuss/67414/Java-1ms-solution-with-comments-in-the-code
 */
public class StrobogrammaticNumberIII2 {
    char[] singles = new char[]{'0','1','8'};
    // Sorted by the first char in ascending order
    char[][] pairs = new char[][]{ {'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'} };
    char[] ans; // buffer of storing the number
    int count = 0; // total count
    char[] l; // char array of low
    char[] h; // char array of high

    // Compare two numbers' char array. Longer one is the larger one.
    // If have same length then compare each char from left to right
    // return positive when s2 > s1, 0 when s2==s1, negative when s2 < s1
    int comp(char[] s1, char[] s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 != len2) return len2-len1;
        else {
            for (int i=0; i < len1; i++) {
                if (s1[i] != s2[i]) return s2[i]-s1[i];
            }
            return 0;
        }
    }
    // Recursion for generating Strobogrammatic numbers of length n
    // starting from both ends. As a result, the numbers are
    // generate in ascending order.
    // Therefore, when when a number is greater than high it returns false
    // and then terminate the loop.
    boolean helper(int n, int s, int e, int len) {
        if (n==0) return false;
        if (len==n) { // a resulting number
            // checking the range
            if ( comp(l, ans) >=0  && comp(ans, h) >=0 ) count++;
            if ( comp(ans, h) < 0) return false; // the nubmer is greater than high
            return true;
        } else if (s==e) { // odd length at the middle position, apply single digit
            for (int i =0 ; i< singles.length; i++) {
                if ( ! ( s == 0 && i == 0 && n > 1)  ) { // first digit can't be 0
                    ans[s] = singles[i];
                    if ( ! helper( n, s+1, e-1, len+1) ) return false;
                }
            }
        } else { // placing two digits at both ends
            for (int i =0 ; i< pairs.length; i++) {
                char[] pair = pairs[i];
                if ( ! ( s == 0 && i == 0)  ) { // first digit can't be 0
                    ans[s] = pair[0];
                    ans[e] = pair[1];
                    if ( ! helper( n, s+1, e-1, len+2 ) ) return false;
                }
            }
        }
        return true;
    }
    // counting the total Strobogrammatic numbers of lengh n
    // without considering the range
    int counts(int n, int next) {
        if (next<=0) return 0;
        if (next==1) return 3;
        if (next==2) return n==next? 4 :5; // first digit can't be 0
        return n==next? 4 * counts(n, next-2) : 5 * counts(n, next-2);
    }

    public int strobogrammaticInRange(String low, String high) {
        int low_len = low.length();
        int high_len = high.length();
        l = low.toCharArray();
        h = high.toCharArray();
        for (int i=low_len; i <= high_len; i++) {
            // generating the numbers only when the length is equal to low or high
            if (i== low_len || i== high_len) {
                ans = new char[i];
                helper(i, 0, i-1, 0);
            } else {
                // counting the total numbers without actualy generating them
                count+=counts(i,i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String low = "50";
        String high = "100";
        StrobogrammaticNumberIII2 strobogrammaticNumberIII2 = new StrobogrammaticNumberIII2();
        System.out.println(strobogrammaticNumberIII2.strobogrammaticInRange(low, high));
    }

}
