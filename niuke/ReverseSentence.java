package niuke;

public class ReverseSentence {
    public String reverseSentence(String str) {
        if (str==null||str.length()<=0) {
            return "";
        }

        char[] reversechars = str.toCharArray();
        char[] res = new char[reversechars.length];

        int pEnd = reversechars.length-1;
        int pStart =  reversechars.length-1;
        int j=0;
        for (int i = reversechars.length - 1; i>=0; i--) {
            if (reversechars[i]==' ') {
                pStart = i+1;
                //提取单词
                for (int k=0; k<pEnd-pStart+1; k++) {
                    res[j] = reversechars[pStart+k];
                    j++;
                }
                res[j]= ' ';
                j++;
                pEnd=i-1;

            }
        }

        for (int k=0; k<pEnd+1; k++) {
            res[j] = reversechars[k];
            j++;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        ReverseSentence r = new ReverseSentence();
        String str = "student. a am I";
        System.out.println(r.reverseSentence(str));
    }
}