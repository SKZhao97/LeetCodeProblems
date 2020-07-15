import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * July 15th
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    int max = 0;
    public boolean isUnique(String s){
        Set<Character> set = new HashSet<>(); // could also use an array with len 26
        for(char c : s.toCharArray()){
            if(set.contains(c))
                return false;
            set.add(c);
        }

        return true;
    }

    public void dfs(String curr, int idx, List<String> arr){

        //pruning
        if(!isUnique(curr))
            return;
        // base case:
        if(idx == arr.size()){
            max = Math.max(max, curr.length());
            return;
        }

        dfs(curr + arr.get(idx), idx+1, arr); // include current string at idx
        dfs(curr, idx+1, arr);   // not include current string at idx
    }

    public int maxLength(List<String> arr) {
        dfs("", 0, arr);
        return max;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters maximumLengthOfAConcatenatedStringWithUniqueCharacters
                = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        System.out.println(maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(arr));
    }
}
