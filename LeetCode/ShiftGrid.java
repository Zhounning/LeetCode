package leetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * ShiftGrid
 */
public class ShiftGrid {
    // 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

    // 每次「迁移」操作将会引发下述活动：
    
    // 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    // 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    // 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    // 请你返回 k 次迁移操作后最终得到的 二维网格。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/shift-2d-grid
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
       
        for (int f = 0; f < k; f++) {
            int lasttemp = grid[n-1][m-1];
            int nexttemp = 0;
    
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    
                    nexttemp = grid[i][j];
                    grid[i][j] = lasttemp;
                    lasttemp = nexttemp;            
                }
            }
        }

        List<List<Integer>> res =new ArrayList<>();

        for (int i = 0; i<n; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j<m; j++) {
                tempList.add( grid[i][j]);
            }
            res.add(tempList);
        }

        return res;
    }
}