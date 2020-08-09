package leetCode;

public class restoreString {
    public String RestoreString(String s, int[] indices) {
        char[] t = new char[s.length()];

        for (int i = 0; i < t.length; i++) {
            int idx = indices[i];
            char ch = s.charAt(i);
            t[idx] = ch;
        }

        return new String(t);
    }

    public static void main(String[] args) {
        restoreString r = new restoreString();
        String s = "codeleet";
        int []indices = {4,5,6,7,0,2,1,3};
        System.out.println(r.RestoreString(s, indices));
    }
}