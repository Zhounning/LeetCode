package leetCode;

public class minOperations {

    public int MinOperations(int n) {
        // int a = (n - 1) * 2 + 1;
        int res = 0;
        // int k = (a + 1) / 2 - 1;
        int k = n - 1;
        while (k>0) {
            res+=k;
            k-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        minOperations m  =new minOperations();
        System.out.println(m.MinOperations(6));
    }
}