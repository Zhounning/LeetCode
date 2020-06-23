/**
 * IsPalindrome
 */
public class IsPalindrome {

    // 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    // 说明：本题中，我们将空字符串定义为有效的回文串。
    public boolean isPalindrome(String s) {
        
        if(s==null||s.length()==0)
        return true;
    
        int p1 = 0;
        int p2 =s.length()-1;

        while (p1<=p2) {
            while(p1<s.length()&&!Character.isLetterOrDigit(s.charAt(p1)))
                p1++;
        
            while(p2>=0&&!Character.isLetterOrDigit(s.charAt(p2)))
                p2--;
            if(p1<=p2){

                if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) return false;
                p1++;
                p2--;
            }
        }

            return true;
    }
    public static void main(String[] args) {
        String s ="0P";
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(s));
    }
}