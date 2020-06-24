package niuke;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        
        if (numbers==null||numbers.length==0){
            return "";
        }
        StringBuilder res= new StringBuilder();
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for(int i = 0; i < str.length; i++){
            res.append(str[i]);
        }
        return res.toString();
    }
}