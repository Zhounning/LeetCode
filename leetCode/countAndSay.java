package leetCode;

public class countAndSay {
    public String CountAndSay(int n) {
        if (n==1) {
            return "1";
        }

        StringBuilder res = new StringBuilder();
        String pre = CountAndSay(n-1);
        int count = 1;
        char ch = pre.charAt(0);
        for (int i = 1; i < pre.length(); i++) {
            //说明换了新数字
            if (ch!=pre.charAt(i)) {
                res.append(count);
                res.append(ch);
                ch = pre.charAt(i);
                count=0;
            }
            count++;
        }

        res.append(count);
        res.append(ch);
        return res.toString();
    }

    public static void main(String[] args) {
        countAndSay c =new countAndSay();
        int n=5;
        System.out.println(c.CountAndSay(n));
    }
}