import java.util.*;

/**
 * 1487. Making File Names Unique
 * https://leetcode.com/problems/making-file-names-unique/
 * June 21st
 */
public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {

        HashMap<String, Integer> map = new HashMap<>();

        String res[] = new String[names.length];

        for(int i = 0; i < names.length; i++) {
            if(map.containsKey(names[i])) {
                Integer val = map.get(names[i]);
                StringBuilder sb = new StringBuilder(names[i]);
                sb.append('(');
                sb.append(val);
                sb.append(')');
                while (map.containsKey(sb.toString())) {
                    val++;
                    sb = new StringBuilder(names[i]);
                    sb.append('(');
                    sb.append(val);
                    sb.append(')');
                }
                res[i] = sb.toString();
                map.put(sb.toString(), 1);
                map.put(names[i], val + 1);
            } else {
                res[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return res;
    }

//    public String[] getFolderNames(String[] names) {
//        Set<String> set = new HashSet<>();
//        String[] res = new String[names.length];
//        int n = 0;
//        for (int i = 0; i < names.length; i++) {
//            if (!set.contains(names[i])) {
//                set.add(names[i]);
//                res[n++] = names[i];
//            } else {
//                int k = 1;
//                String temp = names[i] + '(' + k + ')';
//                while (set.contains(temp)) {
//                    k++;
//                    temp = names[i] + '(' + k + ')';
//                }
//                set.add(temp);
//                res[n++] = temp;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        String[] names = new String[]{"wano","wano","wano","wano"};
        MakingFileNamesUnique makingFileNamesUnique = new MakingFileNamesUnique();
        System.out.println(Arrays.toString(makingFileNamesUnique.getFolderNames(names)));
    }
}
