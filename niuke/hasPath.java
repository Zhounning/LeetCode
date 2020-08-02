package niuke;

/**
 * hasPath
 */
public class hasPath {

    boolean[] isVisited;
    int rows;
    int cols;
    char[] str;
    char[] matrix;

    public boolean HasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols) {
            return false;
        }
        isVisited = new boolean[rows * cols];
        this.matrix = matrix;
        this.rows = rows;
        this.cols = cols;
        this.str = str;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (HasPath(j, i, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean HasPath(int x, int y, int index) {
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            return false;
        }
        // 访问过，或者不相等
        if (isVisited[y * cols + x] || matrix[y * cols + x] != str[index]) {
            return false;
        }

        if (index == str.length - 1) {
            return true;
        }

        isVisited[y * cols + x] = true;
        boolean res = HasPath(x - 1, y, index + 1) || HasPath(x + 1, y, index + 1) || HasPath(x, y - 1, index + 1)
                || HasPath(x, y + 1, index + 1);
        isVisited[y * cols + x] = false;
        return res;
    }

    public static void main(String[] args) {
        hasPath h = new hasPath();
        String s = "abcesfcsadee";
        String str = "abcb";
        System.out.println(h.HasPath(s.toCharArray(), 3, 4, str.toCharArray()));
    }

}