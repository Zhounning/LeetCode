package nowcoder.bibili;

import java.util.HashSet;
import java.util.Scanner;

public class BL5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int res = 1;

        int sqrtN = (int) Math.sqrt((double) n * 2);// 项数 < sqrt(2 * N) + 1
        for (int i = 0; i <= sqrtN; i++) {
            sum += i;
            if (set.contains(sum - n)) {
                res++;
            }
            set.add(sum);

        }
        System.out.println(res);
    }
}