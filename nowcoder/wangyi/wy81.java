package niuke.wangyi;

import java.util.Scanner;

public class wy81 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            res += temp - 1;
        }
        System.out.println(res);
    }
}