package leetCode;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    ArrayList<Integer> res = new ArrayList<>();
    int[][] matrix;
    public List<Integer> SpiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) {
            return null;
        }
        this.matrix = matrix;
        int colums = matrix[0].length;
        int rows = matrix.length;
        int start = 0;
        while (colums>start*2 && rows>start*2) {
            printMatrixCircle(start);
            ++start;
        }
        return res;
    }

    void printMatrixCircle(int start){
        int endX = matrix[0].length-1-start;
        int endY = matrix.length-1-start;
        //第一步，从左到右一定存在
        for (int i = start; i <=endX; i++) {
            res.add(matrix[start][i]);
        }

        //第二步，从上到下
        if (endY>start) {
            for (int i = start+1; i <=endY; i++) {
                res.add(matrix[i][endX]);
            }
        }

        //第三步，从右到左，保证至少两行两列
        if (start<endX && start<endY) {
            for (int i = endX-1; i>=start; i--) {
                res.add(matrix[endY][i]);
            }
        }

        //第四步，从下向上，需要两行三列
        if (start<endX && start<endY-1) {
            for (int i = endY-1; i>=start+1; i--) {
                res.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int [][]matrix =new int[][]{
            new int[]{1}
        };
        spiralOrder s = new spiralOrder();
        System.out.println(s.SpiralOrder(matrix));

    }
}