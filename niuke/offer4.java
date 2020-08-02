package niuke;

public class offer4 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0)
            return false;
        int n = array.length;
        int m = array[0].length;
        int i = 0;
        int j = m - 1;
        // 查看最右上角的位置
        while (i < n && i >= 0 && j < m && j >= 0) {
            if (target == array[i][j])
                return true;
            if (target > array[i][j])
                i++;
            if (target < array[i][j])
                m--;
        }
        return false;
    }
}