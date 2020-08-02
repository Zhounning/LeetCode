package leetCode;

public class isPowerOfTwo {
    public boolean IsPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}