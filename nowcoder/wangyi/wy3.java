package nowcoder.wangyi;

import java.util.Scanner;

public class wy3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < b.length; i++) {
                b[i] = sc.nextInt();
            }
            wy3 wy = new wy3();
            System.out.println(wy.play(b, a));
        }
        sc.close();
    }

    int play(int[] b, int a) {

        for (int i : b) {
            if (a >= i) {
                a += i;
            } else {
                a += GCD(a, i);
            }
        }
        return a;
    }

    int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}