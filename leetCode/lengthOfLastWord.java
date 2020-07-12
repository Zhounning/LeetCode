package leetCode;

public class lengthOfLastWord {
    public int LengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length()-1; i>=0; i--) {
            
            if (s.charAt(i)==' ') {
                break;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        lengthOfLastWord l = new lengthOfLastWord();
        String s= "Hello World";
        System.out.println(l.LengthOfLastWord(s));
    }
}