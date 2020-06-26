package niuke;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

public class FindContinuousSequence {
    //滑动窗口
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum>=3) {
            int small = 1;
            int big =2;
            int mid = (1+sum)/2;
            int curSum = small+big;
            while (small<mid) {
                curSum = (small+big)*(big-small+1)/2;
                if (curSum==sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=small;i<=big;i++){
                        list.add(i);
                    }
                    res.add(list);
                    small++;
                }else if(curSum<sum){
                    big++;
                }else{
                    small++;
                }
            }


       }
       return res;
    }
}