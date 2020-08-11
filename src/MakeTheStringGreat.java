import java.util.*;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else {
                char cur = stack.peek();
                if (cur == s.charAt(i) + 'a' - 'A' || s.charAt(i) == cur + 'a' - 'A') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        MakeTheStringGreat makeTheStringGreat = new MakeTheStringGreat();
        String s = "leEeetcode";
        System.out.println(makeTheStringGreat.makeGood(s));
    }
}
