import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 1471. The k Strongest Values in an Array
 * https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 * June 6th
 */
public class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                if (Math.abs((Integer) t1 - m) > Math.abs((Integer) t2 - m)) {
                    return -1;
                } else if (Math.abs((Integer) t1 - m) < Math.abs((Integer) t2 - m)) {
                    return 1;
                } else {
                    if ((Integer) t1 > (Integer) t2) {
                        return -1;
                    } else if ((Integer) t1 < (Integer) t2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = a[i];
        }
        return res;
    }

    public int[] getStrongestList(int[] arr, int k) {
        Arrays.sort(arr);
        int med = arr[((arr.length - 1) / 2)];
        int[] kStrongest = new int[k];
        ArrayList<Integer> ns = new ArrayList<>();
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int f : arr) ns.add(f); // please comment if any better way to do this [copying int[] into ArrayList]

        ns.sort((i1, i2) -> {
            int diff = Math.abs(i2 - med) - Math.abs(i1 - med);
            if (diff == 0) {
                return i2 - i1;
            }
            return diff;
        });
        for (int i = 0; i < k; i++) {
            kStrongest[i] = ns.get(i);
        }
        return kStrongest;
    }


    public int[] getStrongestHeap(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr.length;
        int med = arr[(m - 1) / 2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((b, a) -> Math.abs(b - med) == Math.abs(a - med) ? (b - a) : Math.abs(b - med) - Math.abs(a - med));
        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = pq.poll();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,11,7,6,8};
        int k = 5;
        TheKStrongestValuesInAnArray theKStrongestValuesInAnArray = new TheKStrongestValuesInAnArray();
        System.out.println(Arrays.toString(theKStrongestValuesInAnArray.getStrongestList(arr, k)));
        System.out.println(Arrays.toString(theKStrongestValuesInAnArray.getStrongestHeap(arr, k)));
    }
}
