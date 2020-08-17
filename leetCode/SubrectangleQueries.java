package leetCode;

public class SubrectangleQueries {
    int[][] resctangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.resctangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                resctangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return resctangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle = { { 1, 2, 1 }, { 4, 3, 4 }, { 3, 2, 1 }, { 1, 1, 1 } };
        SubrectangleQueries obj = new SubrectangleQueries(rectangle);
    }
}