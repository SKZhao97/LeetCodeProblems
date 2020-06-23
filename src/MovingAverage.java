import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * June 22th
 */
public class MovingAverage {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    double sum = 0;
    int size;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > size) {
            int remove = queue.poll();
            sum -= remove;
        }
        return sum/queue.size();
    }

//    int size;
//    List queue = new ArrayList<Integer>();
//    public MovingAverage(int size) {
//        this.size = size;
//    }
//​
//    public double next(int val) {
//        queue.add(val);
//        // calculate the sum of the moving window
//        int windowSum = 0;
//        for(int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
//            windowSum += (int)queue.get(i);
//​
//        return windowSum * 1.0 / Math.min(queue.size(), size);
//    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
