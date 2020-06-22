/**
 * 1486. XOR Operation in an Array
 * https://leetcode.com/problems/xor-operation-in-an-array/
 * June 21st
 */
public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int start = 0;
        XOROperationInAnArray xorOperationInAnArray = new XOROperationInAnArray();
        System.out.println(xorOperationInAnArray.xorOperation(n, start));
    }
}
