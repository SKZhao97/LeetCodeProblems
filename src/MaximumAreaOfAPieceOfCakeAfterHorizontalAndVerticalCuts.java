import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * May 30th
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length, n = verticalCuts.length,
                H = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]),
                V = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < horizontalCuts.length; ++i) {
            H = Math.max(H, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; ++i) {
            V = Math.max(V, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)(H * 1L * V % 1_000_000_007);
    }

    public static void main(String[] args) {
//        int[] horizontalCuts = new int[]{1,2,4};
//        int[] verticalCuts = new int[]{1,3};
        int[] horizontalCuts = new int[]{3};
        int[] verticalCuts = new int[]{1};
        int h = 5;
        int w = 4;
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts
                = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
        System.out.println(maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts.maxArea(h, w, horizontalCuts, verticalCuts));
    }
}
