import java.util.Arrays;

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * June 12th
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l < r) {
            int mid = helper(points, l, r);
            if (mid == K)
                break;
            else if(mid < K)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while(l<r) {
            while(l < r && compare(points[r], pivot) >= 0) r--;
            points[l] = points[r];
            while(l < r && compare(points[l], pivot) <= 0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }

    public int compare(int[] p1, int[] p2) {
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = new int[][]{{1,3},{-2,2}};
        int k = 1;

        int[][] res = kClosestPointsToOrigin.kClosest(points, k);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
