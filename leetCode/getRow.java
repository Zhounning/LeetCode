package leetCode;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    public List<Integer> GetRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        rowIndex++;
        if (rowIndex==0) {
            return res;
        }

        int[] array = new int[rowIndex];
        array[0] =1;
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i-1; j>=1; j--) {
                array[j] = array[j] + array[j-1];
            }
            array[i] = 1;
        }

        for (int i : array) {
            res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        getRow g = new getRow();
        int rowIndex = 2;
        System.out.println(g.GetRow(rowIndex));
    }
}