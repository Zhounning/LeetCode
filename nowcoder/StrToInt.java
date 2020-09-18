package nowcoder;

public class StrToInt {
    public int strToInt(String str) {
        int res = 0;
        if (str!=null && str.length()>0) {
            char[] chars = str.toCharArray();
            int start = 0;
            boolean isPositive =true;

            if (chars[0]=='+') {
                isPositive =true;
                start = 1;
            }else if (chars[0]=='-') {
                isPositive =false;
                start = 1;
            }

            for (int i = start; i < chars.length; i++) {
                
                if (chars[i]>='0' && chars[i]<='9') {
                    res = res*10+chars[i]-'0';
                }else{
                    res=0;
                    break;
                }
            }

            if (!isPositive) {
                res = 0-res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StrToInt s = new StrToInt();
        System.out.println(s.strToInt("1a33"));
    }
}