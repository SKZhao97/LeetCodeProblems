import java.util.*;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 * May 30th
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            set.add(i);
        }
        int ans = 0;
//        Arrays.sort(connections, (a,b)->{
//            if (a[0] == 0 || a[1] == 0) {
//                return -1;
//            } else if (b[0] == 0 || b[1] == 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });
        while (set.size() > 0) {
            for (int[] e : connections) {

                if (!set.contains(e[0]) && set.contains(e[1])) {
                    set.remove(e[1]);
                    ans++;
                } else if (!set.contains(e[1]) && set.contains(e[0])) {
                    set.remove(e[0]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        int[][] connections = new int[][]{{1, 2},{2,0}};
        int n = 2;
        ReorderRoutesToMakeAllPathsLeadToTheCityZero reorderRoutesToMakeAllPathsLeadToTheCityZero
                = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        System.out.println(reorderRoutesToMakeAllPathsLeadToTheCityZero.minReorder(n, connections));
    }
}
