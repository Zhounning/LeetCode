package leetCode;

public class multiply {
    public String Multiply(String num1, String num2) {
        int l1 =num1.length();
        int l2 =num2.length();
        if (l1==0||l2==0) {
            return "0";
        }
        char[] ans = new char[l1+l2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = '0';
        }
        for (int i = l1-1; i>=0; i--) {
            int step = 0;//代表进位
            for (int j = l2-1; j>=0; j--) {
                int mul =(num1.charAt(i)-'0')* (num2.charAt(j) - '0');
                int sum = ans[i+j+1] - '0' + step + mul % 10;
                //i+j+1 从末位开始找对应的位置。然后填写数字
                ans[i+j+1]=(char)(sum%10+'0');
                step = sum / 10 + mul / 10; //相加和相乘的进位
            }
            //最后的进位
            ans[i] += step;
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i]!='0') {
                return String.copyValueOf(ans, i, l1+l2-i);
            }
        }
        return "0";
    }
    public static void main(String[] args) {
        multiply m =new multiply();
        String num1="9";
         String num2="99";
         System.out.println(m.Multiply(num1, num2));
    }
}