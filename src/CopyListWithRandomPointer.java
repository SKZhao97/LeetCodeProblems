import java.util.HashMap;

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * June 17th
 */
public class CopyListWithRandomPointer {
    HashMap<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);

        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode).random;
            newNode.next = getClonedNode(oldNode).next;
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return null;
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (visited.containsKey(node)) {
                return visited.get(node);
            } else {
                visited.put(node, new Node(node.val));
                return visited.get(node);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node head = new Node(1);
        System.out.println(copyListWithRandomPointer.copyRandomList(head));
    }
}
