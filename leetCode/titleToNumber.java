package leetCode;

public class titleToNumber {
    public int TitleToNumber(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 26;
            res += ((ch - 'A') + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        titleToNumber t = new titleToNumber();
        String s = "ZY";
        System.out.println(t.TitleToNumber(s));
    }
}