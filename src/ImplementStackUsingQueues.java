import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 * July 2nd
 */
public class ImplementStackUsingQueues {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        int res = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();
        implementStackUsingQueues.push(1);
        implementStackUsingQueues.push(2);
        implementStackUsingQueues.push(3);
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.empty());
    }
}
