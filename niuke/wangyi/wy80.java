package niuke.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class wy80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> position = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            position.add(sc.nextInt());
        }

        int result = 0;
        int i = 0;
        while (i <= position.size() - 3) {
            int secondIndex = position.lastIndexOf(position.get(i));
            result += secondIndex - i - 1;
            position.remove(secondIndex);
            i++;
        }
        System.out.println(result);

        sc.close();
    }
}