package nowcoder.bibili;

import java.util.Scanner;

public class BL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int n = 10;

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            if (n % 2 == 0) {
                sb.append(3);
                n = n / 2 - 1;
            } else {
                sb.append(2);
                n = (n - 1) / 2;
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}