package leetCode;

import java.util.Arrays;

public class plusOne {
    public int[] PlusOne(int[] digits) {

        int Carry = 0;//表示进位
        
        int i=digits.length-1;
        do {
            digits[i] = digits[i]+1;
            Carry  = (digits[i] )/10;
            digits[i] =digits[i]%10;
            i--;
        } while (Carry!=0 && i>=0);



        if (Carry==0) {
            return digits;
        }

        int []res = new int[digits.length+1];
        res[0] =1;
        System.arraycopy(res, 1, digits, 0, digits.length);
        return res;
    }

    public static void main(String[] args) {
        plusOne p =new plusOne();
        int[]digits = {9,9,9};
        int []res=p.PlusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}