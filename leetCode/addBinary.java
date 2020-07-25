package leetCode;

public class addBinary {
    public String AddBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // 表示进位

        while (i >= 0 || j >= 0) {
            // 这种写法比较巧妙
            carry += i >= 0 ? (a.charAt(i) - '0') : 0;
            carry += j >= 0 ? (b.charAt(j) - '0') : 0;
            i--;
            j--;
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        // 最后一位
        if (carry > 0) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        addBinary ad = new addBinary();
        String a = "11";
        String b = "1";
        System.out.println(ad.AddBinary(a, b));
    }
}