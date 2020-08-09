package leetCode;

public class findKthBit {

    // public char FindKthBit(int n, int k) {
    // int len = 1;
    // long num = 0;

    // for (int i = 2; i <= n; i++) {
    // long temp = num;
    // num = num << 1;
    // num = num | 1;
    // temp = (~temp) & ((1 << len) - 1);
    // int j = len;
    // while (j > 0) {
    // num = num << 1;
    // num = num | (temp & 1);
    // temp = temp >> 1;
    // j--;
    // }
    // len = len * 2 + 1;
    // }
    // StringBuilder s = new StringBuilder(Long.toBinaryString(num));
    // for (int i = s.length(); i < len; i++) {
    // s.insert(0, "0");
    // }
    // return s.charAt(k - 1);
    // }

    public char FindKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');// n=1

        for (int i = 2; i <= n; i++) {
            // invert
            StringBuilder temp = new StringBuilder(sb);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '0') {
                    temp.setCharAt(j, '1');
                } else {
                    temp.setCharAt(j, '0');
                }
            }
            // reverse
            int left = 0, right = temp.length() - 1;
            while (left < right) {
                char c = temp.charAt(left);
                temp.setCharAt(left, temp.charAt(right));
                temp.setCharAt(right, c);
                left++;
                right--;
            }
            sb.append('1');
            sb.append(temp);
        }
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        findKthBit f = new findKthBit();
        int n = 4;
        int k = 11;
        // System.out.println(f.FindKthBit(n, k));
        int len = 1;
        for (int i = 0; i < 10; i++) {
            len = len * 2 + 1;
        }
        System.out.println(len);
    }
}