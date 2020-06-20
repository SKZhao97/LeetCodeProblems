import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class HitCounterMap {
    Queue<Integer> hits = new LinkedList<>();
    Map<Integer, Integer> counts = new HashMap<>();

    /** Initialize your data structure here. */
    public HitCounterMap() {}

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (counts.containsKey(timestamp)) counts.put(timestamp, counts.get(timestamp) + 1);
        else {
            update(timestamp);
            hits.add(timestamp);
            counts.put(timestamp, 1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        update(timestamp);
        int r = 0;
        for (int i : counts.values()) r += i;
        return r;
    }

    // Note that this is O(300) because we never have more than 300 items in the queue or counts.
    // In the worst case, we'd only need to remove 300 items.
    private void update(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) counts.remove(hits.poll());
    }
}