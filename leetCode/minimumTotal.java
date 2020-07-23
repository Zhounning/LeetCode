package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimumTotal {

    public int MinimumTotal(List<List<Integer>> triangle) {
        if (triangle==null) {
            return 0;
        }

        int []array = new int[triangle.size()];
        array[0] = triangle.get(0).get(0);
        int minNum = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            array[i] = array[i-1]+temp.get(i);

            for (int j = i-1; j>=1; j--) {
                array[j] =  Math.min(array[j],array[j-1])+temp.get(j);   
            }

            array[0] = array[0]+temp.get(0);
        }

        for (int i : array) {
            minNum = Math.min(i,minNum);
        }
        return minNum;
    }

    public static void main(String[] args) {
        minimumTotal m = new minimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);c.add(5);c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);d.add(1);d.add(8);d.add(3);
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);
        System.out.println(m.MinimumTotal(triangle));
    }
}