package leetCode;
/**
 * Exist
 */
public class Exist {
    // 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

    // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    
    //  
    
    // 示例:
    
    // board =
    // [
    //   ['A','B','C','E'],
    //   ['S','F','C','S'],
    //   ['A','D','E','E']
    // ]
    
    // 给定 word = "ABCCED", 返回 true
    // 给定 word = "SEE", 返回 true
    // 给定 word = "ABCB", 返回 false
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/word-search
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
     // 盘面上有多少行
     private int m;
     // 盘面上有多少列
     private int n;
     private String word;
     private char[][] board;
     private boolean[][] marked;
 
    public  boolean exist(char[][] board, String word) {

        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs2(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;


    }

    public  boolean dfs(char[][]board,String word,boolean [][]isVisted,int i,int j,int n){

        if (n==word.length()) {
            return true;
        }

        boolean res = false;
        boolean cur = false;

        //对四个方位进行判断
        if (i-1>=0   &&  isVisted[i-1][j] == false && board[i-1][j]==word.charAt(n)){
            isVisted[i-1][j] = true;
            cur=dfs(board, word, isVisted,i-1, j,n+1);
            res = cur || res;
            isVisted[i-1][j] = false;
        }

        if (i+1<board.length && isVisted[i+1][j] == false && board[i+1][j]==word.charAt(n)){
            isVisted[i+1][j] = true;
            cur=dfs(board, word,isVisted, i+1, j,n+1);
            res = cur || res;
            isVisted[i+1][j] = false;
        }

        if (j-1>=0 && isVisted[i][j-1] == false&&board[i][j-1]==word.charAt(n)){
            isVisted[i][j-1] = true;
            cur=dfs(board, word,isVisted, i, j-1,n+1);
            res = cur || res;
            isVisted[i][j-1] = false;
        }

        if (j+1<board[0].length && isVisted[i][j+1] ==false && board[i][j+1]==word.charAt(n)){
            isVisted[i][j+1] = true;
            cur=dfs(board, word, isVisted,i, j+1,n+1);
            res = cur || res;
            isVisted[i][j+1] = false;
        }

        return res;
    }


    public boolean dfs2(int i,int j,int start){
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs2(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }




    public static void main(String[] args) {
        char[][] board = new char[][]  {
            { 'A','B','C','E'},
            { 'S','F','C','S'},
            { 'A','D','E','E'}
        };
        String word = "ABCB";
        // exist(board, word);
    }
}