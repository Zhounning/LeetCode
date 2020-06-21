package niuke;

import java.util.ArrayList;

public class printMatrix {

    public ArrayList<Integer> PrintMatrix(int [][] matrix) {
       if (matrix==null||matrix.length==0||matrix[0].length==0) {
           return null;
       }

       int colums = matrix[0].length;
       int rows = matrix.length;
       int start = 0;
       ArrayList<Integer> res = new ArrayList<>();
       while (colums>start*2 && rows>start*2) {
            ArrayList<Integer> temp = printMatrixCircle(matrix,start);
            if (temp!=null) {
                res.addAll(temp);
            }
            ++start;
       }
       return res;
    }


    public ArrayList<Integer> printMatrixCircle(int [][]matrix,int start){
        int endX = matrix[0].length-1-start;
        int endY = matrix.length-1-start;
        ArrayList<Integer> res = new ArrayList<>();
        //从左向右,条件是一定进行
        for (int i = start; i <=endX; i++) {
            res.add(matrix[start][i]);
        }

        //从上到下，保证至少两行
        if (start<endY) {
            for (int i = start+1; i <=endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        //从右到左，保证至少两行两列
        if (start<endX&&start<endY) {
            for (int i = endX-1; i >=start; i--) {
                res.add(matrix[endY][i]);
            }
        }
        //从下到上，至少三行两列
        if (start<endX && start<endY-1) {
            for (int i = endY-1; i>=start+1; i--) {
                res.add(matrix[i][start]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]matrix =new int[][]{
            new int[]{1}
        };
        printMatrix printMatrix = new printMatrix();
        printMatrix.PrintMatrix(matrix);
    }
}