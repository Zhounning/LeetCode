package niuke;

import java.util.Arrays;

public class isContinuous {
    public boolean IsContinuous(int [] numbers) {
        if(numbers==null||numbers.length<=0)return false;
        //先进行排序
        Arrays.sort(numbers);
        //统计大小王的个数
        int numOfZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]!=0) {
                break;
            }
            numOfZero++;
        }
        //统计间隔
        int small = numOfZero;
        int big = small+1;
        int numOfGap = 0;
        while (big<numbers.length) {
            if (numbers[small]==numbers[big]) {
                return false;
            }
            numOfGap += numbers[big]-numbers[small]-1;
            small = big;
            big++;
        }

        return numOfGap-numOfZero<=0;
    }

    public static void main(String[] args) {
        isContinuous i = new isContinuous();
        int [] numbers = {0,3,1,6,4};
        System.out.println( i.IsContinuous(numbers));
    }
}