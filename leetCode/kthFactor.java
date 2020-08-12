package leetCode;

public class kthFactor {
    public int kthFactor(int n, int k) {
        int res = -1;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                j++;
            }

            if (j == k) {
                return i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        kthFactor kt = new kthFactor();
        int n = 12;
        int k = 3;
        System.out.println(kt.kthFactor(n, k));
    }
}