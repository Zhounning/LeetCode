package leetCode;

import java.util.ArrayList;
import java.util.List;

public class getPermutation {
    public String GetPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder("123456789");
        int[] f= new int[n];
        f[0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i] = f[i-1]*i;
        }
        --k;
        for (int i = n; i >=1; --i) {
            int j = k/f[i-1];
            k%=f[i-1];
            res.append(num.charAt(j));
            num.deleteCharAt(j);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        getPermutation g =new getPermutation();
        int n=3;
        int k=3;
        System.out.println(g.GetPermutation(n, k));
    }

    

}