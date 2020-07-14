package leetCode;

public class searchMatrix {
    //矩阵从左到右为升序，从上到下也为升序
    public boolean SearchMatrix(int[][] matrix, int target) {
        if (matrix==null) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0,j=n-1;
        while (  i<m && j>=0) {
            if (matrix[i][j]==target) {
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        searchMatrix s = new searchMatrix();
        int[][] matrix = new int[][]{
            new int[]{1,   3,  5,  7},
            new int[]{10, 11, 16, 20},
            new int[]{23, 30, 34, 50}
        };
        int target = 12;
        System.out.println(s.SearchMatrix(matrix, target));
    }
}