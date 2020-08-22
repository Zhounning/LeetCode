package leetCode;

public class thousandSeparator {
    public String ThousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        int mod = 1000;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int temp = n % mod;
            sb.insert(0, temp);

            n = n / mod;
            if (n != 0) {
                if (temp < 100) {
                    sb.insert(0, 0);
                }
                sb.insert(0, '.');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        thousandSeparator t = new thousandSeparator();
        System.out.println(t.ThousandSeparator(1234));
    }
}