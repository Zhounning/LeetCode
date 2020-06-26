package niuke;

public class FindNumsAppearOnce {
    
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length<=0) {
            return;
        }
        int resultExclusiveOR = 0;
        for (int i : array) {
            resultExclusiveOR^=i;
        }
        int indexBit = FindFirstBitIs1(resultExclusiveOR);

        for (int i : array) {
            if (IsBit1(i, indexBit)) {
                num1[0]^=i;
            }else{
                num2[0]^=i;
            }
        }

    }

    int FindFirstBitIs1(int num){
        int indexBit = 0;
        while ((num & 1)==0) {
            num = num>>1;
            ++indexBit;
        }
        return indexBit;
    }

    boolean IsBit1(int num,int indexBit){
        num = num>>indexBit;
        return (num&1)==0;
    }
}