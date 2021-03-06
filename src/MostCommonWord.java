import java.util.*;

/**
 * 819. Most Common Word
 * https://leetcode.com/problems/most-common-word/
 * June 16th
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph+=".";

        Map<String, Integer> count = new HashMap();

        Set<String> banset = new HashSet(Arrays.asList(banned));

        String ans ="";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()){
            if (Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            } else if(word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)){
                    count.put(finalword,count.getOrDefault(finalword,0) + 1);
                    if (count.get(finalword) > ansfreq){
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        MostCommonWord mostCommonWord = new MostCommonWord();
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }
}
