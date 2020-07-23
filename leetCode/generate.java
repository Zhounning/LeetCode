package leetCode;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public List<List<Integer>> Generate(int numRows) {
        
        List<List<Integer>>res = new ArrayList<>();
        if (numRows==0) {
            return res;
        }
        List<Integer>array = new ArrayList<>();
        array.add(1);
        res.add(array);

        for (int i = 1; i < numRows; i++) {

            array = new ArrayList<>();
            array.add(1);
            List<Integer> temp = res.get(i-1);
            for (int j = 1; j < i; j++) {
                array.add(temp.get(j-1)+temp.get(j));
            }
            array.add(1);
            res.add(array);
        }
        return res;
    }

    public static void main(String[] args) {
        generate g =new generate();
        int numRows = 3;
        System.out.println(g.Generate(numRows));
    }
}