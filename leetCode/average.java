package leetCode;

import java.util.Arrays;

public class average {
    public double Average(int[] salary) {
        Arrays.sort(salary);
        double res = 0;
        int n = salary.length;
        for (int i = 1; i < n - 1; i++) {
            res += salary[i];
        }

        return res / (n - 2);
    }

    public static void main(String[] args) {
        average a = new average();
        int[] salary={4000,3000,1000,2000} ;
        System.out.println(a.Average(salary));
    }
}