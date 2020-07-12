package leetCode;

import java.util.Arrays;

public class generateMatrix {
    int[][]matrix;
    int num = 1;
    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        int colums = matrix[0].length;
        int rows = matrix.length;
        int start = 0;
        while (colums>start*2 && rows>start*2) {
            printMatrixCircle(start);
            ++start;
        }
        return matrix;
    }

    void printMatrixCircle(int start){
        int endX = matrix[0].length-1-start;
        int endY = matrix.length-1-start;
        //从左到右
        for (int i = start; i <=endX; i++) {
            matrix[start][i] = num;
            num++;
        }

        //从上到下
        if (endY>start) {
            for (int i = start+1; i <=endY; i++) {
                matrix[i][endX] = num;
                num++;
            }
        }

        //从右到左
        if (start<endX && start<endY) {
            for (int i = endX-1;i>=start; i--) {
                matrix[endY][i]=num;
                num++;
            }   
        }
        //从下向上
        if (start<endX && start<endY-1) {
            for (int i = endY-1; i>=start+1; i--) {
                matrix[i][start]=num;
                num++;
            }
        }
    }

    public static void main(String[] args) {
        generateMatrix g =new generateMatrix();
        int n=3;
        int[][] res = g.generateMatrix(n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}