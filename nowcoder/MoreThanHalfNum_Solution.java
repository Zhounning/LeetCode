package nowcoder;

public class MoreThanHalfNum_Solution {

    public int moreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length==0) {
            return 0;
        }
        int res = array[0];
        int count = 0;
        for (int i : array) {
            if (res==i) {
                ++count;

            }else{
                if (count==0) {
                    res = i;
                    count=1;
                }else{
                    --count;
                }
            }
        }
        count=0;
        for (int j : array) {
            if (j==res) {
                ++count;   
            }
        }

        if (count<array.length/2) {
            return 0;
        }
        return res;
    }
}