package leetCode;

public class convert {
    public String Convert(String s, int numRows) {
        if (s==null|s.length()<=0)return "";
        if(numRows==1) return s;

        
        int m = numRows-1;
        int n = numRows+numRows-2;
        int index = 0;
        StringBuilder [] helperBuilder = new StringBuilder[numRows];
        for (int i = 0; i < helperBuilder.length; i++) {
            helperBuilder[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            
            //判断在第几行
            index = i%n<=m? i%n :  m-i%m;
            helperBuilder[index].append(s.charAt(i));
        }
        for (int i = 1; i < helperBuilder.length; i++) {
            helperBuilder[0].append(helperBuilder[i]);
        }

        return helperBuilder[0].toString();
    }

    public static void main(String[] args) {
        convert c = new convert();
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(c.Convert(s, numRows));
    }
}