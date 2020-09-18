package nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Permutation {
    
    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            //使用str.toCharArray()比较好
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    
   
     private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
 
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Permutation p =new Permutation();
        String str = "abb";
        ArrayList<String> res = p.permutation(str);
        for (String string : res) {
            System.out.println(string);
        }
    }
}