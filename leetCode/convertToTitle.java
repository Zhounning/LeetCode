package leetCode;

public class convertToTitle {
    public String ConvertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n != 0) {
            --n;
            int modNum = n % 26;
            n = n / 26;
            res.insert(0, (char) ('A' + modNum));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        convertToTitle c = new convertToTitle();
        int n = 28;
        System.out.println(c.ConvertToTitle(n));
    }
}