package leetCode;

public class romanToInt {
    public int RomanToInt(String s) {
        if(s==null||s.length()==0)  return 0;
        int preNum = getValue(s.charAt(0));
        int curNum = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            curNum = getValue(s.charAt(i));
            res = preNum>=curNum? res+preNum:res-preNum;
            preNum = curNum;
        }

        res +=preNum;
        return res;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}