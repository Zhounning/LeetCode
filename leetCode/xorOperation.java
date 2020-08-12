package leetCode;

public class xorOperation {

    public int XorOperation(int n, int start) {
        int res = start + 2 * 0;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }

    public static void main(String[] args) {
        xorOperation x = new xorOperation();
        int n = 10, start = 5;
        System.out.println(x.XorOperation(n, start));
    }
}