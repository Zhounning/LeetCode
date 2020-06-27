package niuke;

public class LastRemaining_Solution {
    public int lastRemaining_Solution(int n, int m) {

     if (n <= 0||m<=0) return -1; 
        int index = 0;
        for (int i=2; i<=n; ++i) {
            index = (index + m) % i;
        }
        return index;
    }
}