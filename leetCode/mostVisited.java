package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * mostVisited
 */
public class mostVisited {

    public List<Integer> MostVisited(int n, int[] rounds) {
        int[] hash = new int[n + 1];
        int count = 0;
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = i == 0 ? rounds[i] : rounds[i] + 1;
            int end = rounds[i + 1];
            if (start > n) {
                start = 1;
            }
            while (start != end) {
                hash[start]++;
                count = Math.max(count, hash[start]);
                start++;
                if (start > n) {
                    start = 1;
                }
            }
            hash[end]++;
            count = Math.max(count, hash[end]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == count) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        mostVisited m = new mostVisited();
        int n = 7;
        int[] rounds = {1,3,5,7 };
        System.out.println(m.MostVisited(n, rounds));
    }
}