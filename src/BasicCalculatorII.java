import java.util.Stack;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 * June 17th
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        char[] expr = (s.replaceAll(" ", "") + '+').toCharArray();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;

        for (char c : expr) {
            if (Character.isDigit(c)) {
                num = (num * 10) + c - '0';
            } else {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }

        return stack.stream().mapToInt(x -> x).sum();
    }

    public static void main(String[] args) {
        String str = "3+2*2";
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate(str));
    }
}
