package leetCode;

public class totalNQueens {
      //存储每一行皇后放的位置
      int rows[];
      // 主对角线
      int hills[];
      // 次对角线
      int dales[];
      int n;
      int solutionOfNum=0; 
    public int TotalNQueens(int n) {
        this.n = n;
        rows = new int[n];
        //主对角线大一些是为了防止相减出现出现负数
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
    
        backtrack(0);
        return solutionOfNum;    
    }

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col) {
        rows[col] = 1;
        //表示那条对角线被填
        hills[row - col + 2 * n] = 1;  // "hill" diagonals
        dales[row + col] = 1;   //"dale" diagonals
    }
    
    public void removeQueen(int row, int col) {
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
          if (isNotUnderAttack(row, col)) {
            placeQueen(row, col);
            // 放满了
            if (row + 1 == n) solutionOfNum++;
              // if not proceed to place the rest
            else backtrack(row + 1);
            // backtrack
            removeQueen(row, col);
          }
        }
    }

    public static void main(String[] args) {
        totalNQueens t = new totalNQueens();
        int n=4;
        System.out.println(t.TotalNQueens(n));
    }

}