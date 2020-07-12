package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {
    public boolean IsValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();//每一行的set
            Set<Character> colSet = new HashSet<>();//每一列的set
            Set<Character> charSet = new HashSet<>(); //3*3的相关
            for (int j = 0; j < 9; j++) {
               
                if (board[i][j]!='.' && rowSet.contains(board[i][j])) {
                    return false;
                }else{
                    rowSet.add(board[i][j]);
                }

                if (board[j][i]!='.' && colSet.contains(board[j][i])) {
                    return false;
                }else{
                    colSet.add(board[j][i]);
                }

               
                if ( board[(i/3)*3+j/3][(i%3)*3+j%3]!='.' && charSet.contains( board[(i/3)*3+j/3][(i%3)*3+j%3])) {
                    return false;
                }else{
                    charSet.add( board[(i/3)*3+j/3][(i%3)*3+j%3]);
                }
            }
        }
        return true;
    }

    public boolean IsValidSudoku2(char[][] board) {
        // 初始数据
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
        rows[i] = new HashMap<Integer, Integer>();
        columns[i] = new HashMap<Integer, Integer>();
        boxes[i] = new HashMap<Integer, Integer>();
        }

        // 验证数据
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                int n = (int)num;
                int box_index = (i / 3 ) * 3 + j / 3;

                // keep the current cell value
                rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                // check if this value has been already seen before
                if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isValidSudoku i =new isValidSudoku();
        char[][] board = new char[][]{
            new char[]{'8','3','.','.','7','.','.','.','.'},
            new char[]{'6','.','.','1','9','5','.','.','.'},
            new char[]{'.','9','8','.','.','.','.','6','.'},
            new char[]{'8','.','.','.','6','.','.','.','3'},
            new char[]{'4','.','.','8','.','3','.','.','1'},
            new char[]{'7','.','.','.','2','.','.','.','6'},
            new char[]{'.','6','.','.','.','.','2','8','.'},
            new char[]{'.','.','.','4','1','9','.','.','5'},
            new char[]{'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(i.IsValidSudoku(board));
    }
}