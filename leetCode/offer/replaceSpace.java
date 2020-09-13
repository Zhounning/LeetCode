package leetCode.offer;

/**
 * replaceSpace
 */
public class replaceSpace {

    public String ReplaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final String a = "a";
        String b = "b";
        System.out.println((a + b) == (a + b));
    }
}