package nowcoder;

public class LeftRotateString {
    
    public String leftRotateString(String str,int n) {

        if (str==null||str.length()<=0||str.length()<n) {
            return "";
        }
        char[] chars = str.toCharArray();
        char[] temp = new char[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[i];
        }
       
        for (int i = 0; i < chars.length; i++) {
            if (i<chars.length-n) {
                chars[i] = chars[i+n];
                
            }else{
                chars[i] = temp[i-chars.length+n];
            }
        }

        return String.valueOf(chars);

    }
}