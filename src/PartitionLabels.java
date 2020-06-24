import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/
 * June 23rd
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        int start = 0;
        for (int end = 0; end < S.length(); end++) {
            char right = S.charAt(end);
            int rightest = map.get(right);
            while (end < rightest) {
                right = S.charAt(end);
                rightest = Math.max(map.get(right), rightest);
                end++;
            }
            res.add(end - start + 1);
            start= end + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels.partitionLabels(s));
    }
}
