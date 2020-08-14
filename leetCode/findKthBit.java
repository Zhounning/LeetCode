package leetCode;

public class findKthBit {

    // 使用位运算，答案错误，因为最多只能计算64位
    public char FindKthBit(int n, int k) {
        int len = 1;
        long num = 0;

        for (int i = 2; i <= n; i++) {
            long temp = num;
            num = num << 1;
            num = num | 1;
            temp = (~temp) & ((1 << len) - 1);
            int j = len;
            while (j > 0) {
                num = num << 1;
                num = num | (temp & 1);
                temp = temp >> 1;
                j--;
            }
            len = len * 2 + 1;
        }
        StringBuilder s = new StringBuilder(Long.toBinaryString(num));
        for (int i = s.length(); i < len; i++) {
            s.insert(0, "0");
        }
        return s.charAt(k - 1);
    }

    // 进行递归，或者迭代
    public char FindKthBit2(int n, int k) {
        int length = 1;
        for (int i = 1; i < n; i++) {
            length = 2 * length + 1;
        }
        k = k - 1;
        int count = 0;
        while (n > 1) {
            if (k == length / 2) {
                return count % 2 == 0 ? '1' : '0';
            } else if (k < length / 2) {
                // 啥都不用干
            } else {
                k = length - 1 - k;
                count++;
            }
            --n;
            length = (length - 1) / 2;
        }
        return count % 2 == 0 ? '0' : '1';
    }

    public static void main(String[] args) {
        findKthBit f = new findKthBit();
        int n = 4;
        int k = 12;
        System.out.println(f.FindKthBit2(n, k));

    }
}