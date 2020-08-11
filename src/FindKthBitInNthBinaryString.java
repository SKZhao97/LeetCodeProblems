public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        String res = "0";
        for (int i = 0; i < n; i++) {
            res += getComplement(res);
        }
        return res.charAt(k - 1);
    }

    public String getComplement(String str) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                temp.append("1");
            } else if (str.charAt(i) == '1') {
                temp.append("0");
            }
        }
        temp.append("1");
        temp.reverse();
        return temp.toString();
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString findKthBitInNthBinaryString = new FindKthBitInNthBinaryString();
        int n = 2;
        int k = 3;
        System.out.println(findKthBitInNthBinaryString.findKthBit(n, k));
    }
}
