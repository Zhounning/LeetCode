package leetCode;

public class nthUglyNumber {
    public int NthUglyNumber(int n) {
        if (n < 0) {
            return 0;
        }

        int[] result = new int[n];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;// 初始化三个指向三个潜在成为最小丑数的位置
        for (int i = 1; i < n; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2)
                p2++;// 为了防止重复需要三个if都能够走到
            if (result[i] == result[p3] * 3)
                p3++;// 为了防止重复需要三个if都能够走到
            if (result[i] == result[p5] * 5)
                p5++;// 为了防止重复需要三个if都能够走到
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        nthUglyNumber nt = new nthUglyNumber();
        int n = 10;
        System.out.println(nt.NthUglyNumber(n));
    }
}