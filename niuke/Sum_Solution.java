package niuke;

public class Sum_Solution {
    //垃圾题目
    public int sum_Solution(int n) {
        boolean x =(n>1) && (n+=sum_Solution(n-1));
        return n;
    }
}