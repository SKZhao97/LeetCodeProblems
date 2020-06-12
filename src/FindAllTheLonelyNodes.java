import java.util.ArrayList;
import java.util.List;

/**
 * 1469. Find All The Lonely Nodes
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
 * June 11th
 */
public class FindAllTheLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getLonelyNodes(root, false, nodes); // root is not lonely
        return nodes;
    }

    private void getLonelyNodes(TreeNode root, boolean isLonely, List<Integer> nodes) {
        if (root == null) return;

        if (isLonely) {
            nodes.add(root.val);
        }

        getLonelyNodes(root.left, root.right == null, nodes);
        getLonelyNodes(root.right, root.left == null, nodes);
    }
}
