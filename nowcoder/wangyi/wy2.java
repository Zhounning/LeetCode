package nowcoder.wangyi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class wy2 {

    public static void main(String[] args) {
        wy2 wy = new wy2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        List<Integer> lightPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lightPos.add(sc.nextInt());
            Collections.sort(lightPos);
        }

        DecimalFormat df = new DecimalFormat("#.00");
        double res = wy.leastLen(l, lightPos);
        System.out.println(df.format(res));
    }

    double leastLen(int l, List<Integer> lightPos) {

        // 起始位置
        int start = 0;
        double len = 0;
        for (Integer integer : lightPos) {
            len = Math.max(len, integer - start);
            start = integer;
        }

        // 最后比较
        len = Math.max(l - lightPos.get(lightPos.size() - 1), len);
        return len / 2;
    }
}