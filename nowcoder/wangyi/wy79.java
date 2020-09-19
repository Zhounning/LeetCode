package nowcoder.wangyi;

public class wy79 {
    public static void main(String[] args) {

        int n = 70;
        int left = 1;
        int right = n / 10;

        while (left < right) {

        }
    }

    int f(int m, int n) {
        int sum = 0;

        while (n != 0) {
            sum += m;
            n = n - m;
            n = n - (n) / 10;
        }
        return sum;
    }
}