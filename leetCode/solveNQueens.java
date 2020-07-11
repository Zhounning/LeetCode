package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {
    //存储每一行皇后放的位置
    int rows[];
    // 主对角线
    int hills[];
    // 次对角线
    int dales[];
    int n;
    List<List<String>> output ;
    // 皇后位置，用于最后的设置
    int queens[];

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }
    
    public List<List<String>> SolveNQueens(int n) {
        output  =new ArrayList<>();
        this.n = n;
        rows = new int[n];
        //主对角线大一些是为了防止相减出现出现负数
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];
    
        backtrack(0);
        return output;        
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        //表示那条对角线被填
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }
    
    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
          int col = queens[i];
          StringBuilder sb = new StringBuilder();
          for(int j = 0; j < col; ++j) sb.append(".");
          sb.append("Q");
          for(int j = 0; j < n - col - 1; ++j) sb.append(".");
          solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
          if (isNotUnderAttack(row, col)) {
            placeQueen(row, col);
            // 放满了
            if (row + 1 == n) addSolution();
              // if not proceed to place the rest
            else backtrack(row + 1);
            // backtrack
            removeQueen(row, col);
          }
        }
    }



}