package leetCode;

import java.util.Arrays;

/**
 * gameOfLife
 */
public class gameOfLife {
    int[] direction = { -1, 0, 1 };

    public void GameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                changeStatue(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }

                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private void changeStatue(int[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        // 活细胞数量
        int viableCell = 0;
        for (int i1 = 0; i1 < direction.length; i1++) {
            for (int j1 = 0; j1 < direction.length; j1++) {
                int x = i + direction[i1];
                int y = j + direction[j1];
                if (x == i && y == j) {
                    continue;
                }
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (board[x][y] == 1 || board[x][y] == -1) {
                        viableCell++;
                    }
                }
            }
        }

        if (board[i][j] == 1) {
            // 先将死亡细胞变成-1
            if (viableCell < 2 || viableCell > 3) {
                board[i][j] = -1;
            }

        } else if (board[i][j] == 0) {
            if (viableCell == 3) {
                // 先将复活细胞设置为2
                board[i][j] = 2;
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife g = new gameOfLife();
        int[][] board = new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
                new int[] { 0, 0, 0 }, };

        g.GameOfLife(board);

        for (int[] is : board) {
            System.out.println(Arrays.toString(is));
        }
    }
}