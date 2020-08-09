package leetCode;

/**
 * makeGood
 */
public class makeGood {

    public String MakeGood(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder(s);
        int i = 0;
        while (i < res.length() - 1) {
            char ch1 = res.charAt(i);
            char ch2 = res.charAt(i + 1);

            if (ch1 == ch2 + 'A' - 'a' || ch1 + 'A' - 'a' == ch2) {
                res.deleteCharAt(i);
                res.deleteCharAt(i);
                i = i > 0 ? i - 1 : 0;
            } else {
                i++;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        makeGood m = new makeGood();
        String s = "abBAcC";
        System.out.println(m.MakeGood(s));
    }
}