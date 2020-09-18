package nowcoder;

public class movingCount {
    boolean []visited;
    int threshold;
    int rows;
    int cols;
    public int MovingCount(int threshold, int rows, int cols)
    {
        if (threshold<=0||rows<=0||cols<=0) {
            return 0;
        }

        visited = new boolean[rows*cols];
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        int count = MovingCountCore(0,0);
        return count;

    }

    int MovingCountCore(int row,int col){
        int count =0;
        if (check(row, col)) {
            visited[row*cols+col]=true;
            count = 1 +MovingCountCore(row-1, col)+MovingCountCore(row+1, col)
                    +MovingCountCore(row, col-1)+MovingCountCore(row, col+1);
        }
        return count;

    }

    boolean check(int row,int col){
        if (row>=0 && row<rows && col>=0 &&col<cols && !visited[row*cols+col]&&
            getDigitSum(row)+getDigitSum(col)<=threshold ) {
            return true;
        }
        return false;
    }

    int getDigitSum(int number){
        int sum = 0;
        while (number>0) {
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        movingCount m = new movingCount();
        System.out.println(m.MovingCount(3,5,5));
    }
}