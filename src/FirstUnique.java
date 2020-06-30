import java.util.*;

/**
 * 1429. First Unique Number
 * https://leetcode.com/problems/first-unique-number/
 * June 29th
 */
public class FirstUnique {

    Map<Integer, Integer> map;
    LinkedHashSet<Integer> unique;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        unique = new LinkedHashSet<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if(map.get(num) == 1){
                unique.add(num);
            }
        }
    }

    public int showFirstUnique() {
        if(unique.size() == 0){
            return -1;
        }

        return unique.iterator().next();
    }

    public void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        if (map.get(value) == 1) {
            unique.add(value);
        } else if (map.get(value) == 2){
            unique.remove(value);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7,7,7};
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(7);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(7);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(17);
        System.out.println(firstUnique.showFirstUnique());
    }
}
