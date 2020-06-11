import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * June 11th
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return 1;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(5);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(1, l5);


        ListNode l8 = new ListNode(6);
        ListNode l7 = new ListNode(2, l8);

        ListNode[] lists = new ListNode[]{l1, l4, l7};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode ans = mergeKSortedLists.mergeKLists(lists);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
