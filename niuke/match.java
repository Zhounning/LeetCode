package niuke;

public class match {
    char[] str;
    char[] pattern;
    public boolean Match(char[] str, char[] pattern){
        if (str==null||pattern==null) {
            return false;
        }
        this.str = str;
        this.pattern = pattern;
        return matchCore(0,0);
        
    }

    boolean matchCore(int sStart,int pStart){
        if (sStart==str.length && pStart == pattern.length) {
            return true;
        }

        if (sStart!=str.length && pStart==pattern.length) {
            return false;
        }
        //不用担心长度越界，因为上面已经进行了判断
        if (pStart<pattern.length-1 && pattern[pStart+1]=='*') {
            if (sStart!=str.length && (pattern[pStart]==str[sStart]||pattern[pStart]=='.')) {
               return matchCore(sStart+1, pStart+2) || matchCore(sStart+1, pStart) ||matchCore(sStart, pStart+2);
            }else{
                return matchCore(sStart, pStart+2);
            }
        }
        if (sStart!=str.length && (pattern[pStart]==str[sStart]||(pattern[pStart]=='.' )))
            return matchCore(sStart+1, pStart+1);

        return false;
    }

    public static void main(String[] args) {
        match m = new match();
        String str ="a";
        String pattern ="a*";
        System.out.println(m.Match(str.toCharArray(), pattern.toCharArray()));

    }
}