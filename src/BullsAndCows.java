import java.util.HashMap;
import java.util.Map;

/**
 * 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/
 * June 22nd
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }

        for (int i = 0; i < guess.length(); i++) {
            if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                b++;
            }
            if (secret.charAt(i) == guess.charAt(i)) {
                b--;
                a++;
            }
        }
        return a + "A" + b + "B";
    }

//    public String getHint(String secret, String guess) {
//        int bulls = 0;
//        int cows = 0;
//        int[] numbers = new int[10];
//        for (int i = 0; i < secret.length(); i++) {
//            if (secret.charAt(i) == guess.charAt(i))
//                bulls++;
//            else {
//                if (numbers[secret.charAt(i) - '0']++ < 0)
//                    cows++;
//                if (numbers[guess.charAt(i) - '0']-- > 0)
//                    cows++;
//            }
//        }
//        return bulls + "A" + cows + "B";
//    }

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        String secret = "1123";
        String guess = "0111";
        System.out.println(bullsAndCows.getHint(secret, guess));
    }
}
