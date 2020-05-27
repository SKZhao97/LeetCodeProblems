import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 248. Strobogrammatic Number III
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 */
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        int l1 = low.length();
        int l2 = high.length();
        long l = Long.parseLong(low);
        long h = Long.parseLong(high);
        for (long i = l1; i <= l2; i++) {
            List<String> temp = helper(i, i);
            for (String str : temp) {
                long t = Long.parseLong(str);
                if (t >= l && t <= h) {
                    res++;
                }
            }
        }
        return res;
    }

    public List<String> helper(long n, long m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }

    public static void main(String[] args) {
        String low = "50";
        String high = "100";
        StrobogrammaticNumberIII strobogrammaticNumberIII = new StrobogrammaticNumberIII();
        System.out.println(strobogrammaticNumberIII.strobogrammaticInRange(low, high));
    }
}
