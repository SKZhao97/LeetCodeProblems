/**
 * 276. Paint Fence
 * https://leetcode.com/problems/paint-fence/
 * June 8th
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int same = k;
        int different = k * (k - 1);
        for (int i = 3; i <= n; i++) {
            int prevDiff = different;
            different = (same + different) * (k - 1);
            same = prevDiff;
        }
        return same + different;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        PaintFence paintFence = new PaintFence();
        System.out.println(paintFence.numWays(n, k));
    }
}
