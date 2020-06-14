import java.util.*;

/**
 * 692. Top K Frequent Words
 * https://leetcode.com/problems/top-k-frequent-words/
 * June 14th
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] t1, String[] t2) {
                if (Integer.parseInt(t2[1]) < Integer.parseInt(t1[1])) {
                    return -1;
                } else if (Integer.parseInt(t2[1]) > Integer.parseInt(t1[1])) {
                    return 1;
                } else {
                    return t1[0].compareTo(t2[0]);
                }
            }
        });

        for (String str : map.keySet()) {
            pq.add(new String[]{str, String.valueOf(map.get(str))});
        }

        List<String> res = new ArrayList<>();
        if (k <= pq.size()) {
            for (int i = 0; i < k; i++) {
                String[] strs = pq.poll();
                res.add(strs[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequentWords.topKFrequent(words, k).size());
    }
}
