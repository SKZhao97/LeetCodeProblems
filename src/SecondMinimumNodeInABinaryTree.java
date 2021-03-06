import java.util.HashSet;
import java.util.Set;

/**
 * 671. Second Minimum Node In a Binary Tree
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * June 6th
 */
public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<>();
        dfs(root, uniques);
        int min = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if(min < v && v < ans)
                ans = v;
        }
        return ans < Long.MAX_VALUE ? (int)ans : -1;
    }
    public void dfs(TreeNode root, Set<Integer> uniques) {
        if(root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }

    int min1;
    long ans = Long.MAX_VALUE;
    public void dfs(TreeNode root) {
        if(root != null) {
            if (min1 < root.val && root.val < ans) { // If a node satisfy the standard, then its children will not be checked
                ans = root.val;
            } else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValueWithoutCollection(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
