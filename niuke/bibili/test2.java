package niuke.bibili;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        test2 t = new test2();
        String []nums = s.split(",");
        System.out.println(t.f(nums));
    }

    public String f(String[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1 + o2) - Integer.valueOf(o2 + o1);
            }
        });

        for (String string : nums) {
            sb.append(string);
        }
        return sb.toString();
    }
}