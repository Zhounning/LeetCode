package niuke;

import java.util.ArrayList;
import java.util.LinkedList;

public class maxInWindows {
    public ArrayList<Integer> MaxInWindows(int [] num, int size)
    {   
        ArrayList<Integer> res = new ArrayList<>();
        if (num==null || num.length<=0 || size<=0 || num.length<size) {
            return res;
        }
        LinkedList<Integer> intQueue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!intQueue.isEmpty() && num[intQueue.peekLast()]<num[i]) {
                intQueue.pollLast();
            }

            intQueue.add(i);

             // 判断队列的头部的下标是否过期
            if (intQueue.peek() + size <= i) {
                intQueue.pop();
            }

           
            if (i+1>=size) {
                res.add(num[intQueue.getFirst()]);    
            }
        }
        return res;
    }
}