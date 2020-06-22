/**
 * 1485. Clone Binary Tree With Random Pointer
 * https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
 * June 21st
 */


import java.util.HashMap;
import java.util.Map;

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

public class CloneBinaryTreeWithRandomPointer {

    Map<Node, NodeCopy> visited = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        NodeCopy newTree = constructTree(root, visited);
        return newTree;
    }

    private NodeCopy constructTree(Node root, Map<Node, NodeCopy> map){
        if(root == null){
            return null;
        }
        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root, newNode);
        newNode.left = constructTree(root.left, map);
        newNode.right = constructTree(root.right, map);
        return newNode;
    }

    private void populateRandom(Node node, NodeCopy newNode, Map<Node, NodeCopy> map){
        if(node == null){
            return;
        }
        if(node.random != null){
            newNode.random = map.get(node.random);
        }
        populateRandom(node.left, newNode.left, map);
        populateRandom(node.right, newNode.right, map);
    }
}