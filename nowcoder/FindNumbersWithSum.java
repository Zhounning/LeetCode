package nowcoder;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array!=null && array.length>0){
            int low = 0;
            int high = array.length-1;
            while (low<high) {
                if (sum==(array[low]+array[high])) {
                    res.add(array[low]);
                    res.add(array[high]);
                    break;
                }else if (sum>array[low]+array[high]) {
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindNumbersWithSum f =new FindNumbersWithSum();
        int [] array = {1,2,4,7,11,15};
        ArrayList<Integer> res = f.findNumbersWithSum(array, 15);
        System.out.println(res);
    }
}