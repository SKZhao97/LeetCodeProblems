/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 * July 1st
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robProperty(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robProperty(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robProperty(root.left);
        int[] right = robProperty(root.right);
        int include = root.val + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{include, exclude};
    }

    public static void main(String[] args) {
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(houseRobberIII.rob(root));
    }
}
