/**
 * 246. Strobogrammatic Number.
 * https://leetcode.com/problems/strobogrammatic-number/
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] strs = num.toCharArray();
        int l = num.length();

        for (int i = 0; i <= l / 2; i++) {
            if (!(strs[i] == '1' && strs[l - 1 - i] == '1'
                    || strs[i] == '0' && strs[l - 1 - i] == '0'
                    || strs[i] == '8' && strs[l - 1 - i] == '8'
                    || strs[i] == '6' && strs[l - 1 - i] == '9'
                    || strs[i] == '9' && strs[l - 1 - i] == '6')) {
                return false;
            }
        }
        return true;//strs[l / 2] == '1' && strs[l - 1 - l / 2] == '1' || strs[l / 2] == '8' && strs[l - 1 - l / 2] == '8';
    }

    public static void main(String[] args) {
        String s = "69";
        StrobogrammaticNumber strobogrammaticNumber = new StrobogrammaticNumber();
        System.out.println(strobogrammaticNumber.isStrobogrammatic(s));
    }
}
