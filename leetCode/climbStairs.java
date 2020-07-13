package leetCode;

public class climbStairs {
    public int ClimbStairs(int n) {
        int a = 1;
        int b = 2;
        int res = 0;

        if (n==1)return a;
        if (n==2)return b;
        
        for (int i = 3; i <=n; i++) {
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        climbStairs c = new climbStairs();
        System.out.println(c.ClimbStairs(4));
    }
}