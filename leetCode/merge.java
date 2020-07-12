package leetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * merge
 */
public class merge {
    
    public int[][] Merge(int[][] intervals) {
        if (intervals==null) {
            return null;
        }
        if (intervals.length<2) {
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Stack<int[]> res = new Stack<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            int[] peek = res.peek();

            //说明两者之间没有重合
            if (L>peek[1]) {
                res.add(intervals[i]);

            }else{
                //进行融合
                peek[1] = Math.max(R, peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        merge m = new merge();
        int[][] intervals = new int[][]{
            new int[]{1,3},
            new int[]{2,6},
            new int[]{8,10},
            new int[]{15,18}
        };
        int [][] res = m.Merge(intervals);
        for (int i = 0; i < res.length; i++) {
        System.out.println(Arrays.toString(res[i]));
            
        }
    }
    
}