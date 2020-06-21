package niuke;

/**
 * Fibonacci
 */
public class Fibonacci {

    public int fibonacci(int n) {

        if (n==0) {return 0;}

        if(n==1){return 1;}

        int a = 0;
        int b= 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }
}