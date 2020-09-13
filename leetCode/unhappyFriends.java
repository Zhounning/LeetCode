package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class unhappyFriends {

    public int UnhappyFriends(int n, int[][] preferences, int[][] pairs) {
        ArrayList<HashMap<Integer, Integer>> maps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            maps.add(new HashMap<>());
        }
        // 构建优先级
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                maps.get(i).put(preferences[i][j], j);
            }
        }
        int ans = 0;
        boolean unhappy[] = new boolean[n];
        for (int i = 0; i < n / 2; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            for (int j = i + 1; j < n / 2; j++) {
                int u = pairs[j][0];
                int v = pairs[j][1];
                // x
                if (isunHappy(x, y, u, v, maps)) {
                    unhappy[x] = true;
                    unhappy[u] = true;
                }

                if (isunHappy(x, y, v, u, maps)) {
                    unhappy[x] = true;
                    unhappy[v] = true;
                }
                // y
                if (isunHappy(y, x, u, v, maps)) {
                    unhappy[y] = true;
                    unhappy[u] = true;
                }

                if (isunHappy(y, x, v, u, maps)) {
                    unhappy[y] = true;
                    unhappy[v] = true;
                }
                // //u
                // if (isunHappy(u, v, x, y, maps)) {
                // ans++;
                // }

                // if (isunHappy(u, v, y, x, maps)) {
                // ans++;
                // }
                // //v
                // if (isunHappy(v, u, x, y, maps)) {
                // ans++;
                // }

                // if (isunHappy(v, u, y, x, maps)) {
                // ans++;
                // }
            }
        }
        for (int i = 0; i < unhappy.length; i++) {
            if (unhappy[i]) {
                ans++;
            }
        }
        return ans;
    }

    boolean isunHappy(int x, int y, int u, int v, ArrayList<HashMap<Integer, Integer>> maps) {
        if (maps.get(x).get(y) > maps.get(x).get(u) && maps.get(u).get(v) > maps.get(u).get(x)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        unhappyFriends u = new unhappyFriends();
        int n = 4;
        // int[][] preferences = { { 1, 2, 3 }, { 3, 2, 0 }, { 3, 1, 0 }, { 1, 2, 0 } };
        int[][] preferences = { { 1, 3, 2 }, { 2, 3, 0 }, { 1, 3, 0 }, { 0, 2, 1 } };
        int[][] pairs = { { 1, 3 }, { 0, 2 } };
        System.out.println(u.UnhappyFriends(n, preferences, pairs));
    }
}