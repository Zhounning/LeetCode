package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minCostConnectPoints {
    public int MinCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        boolean[] isvisit = new boolean[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // 构造图
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                // 加入边
                g.get(i).add(new int[] { j, dist });
                g.get(j).add(new int[] { i, dist });
            }
        }
        // 建立堆,int [0]表示序号，int[1]表示距离
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 直接取第一个点
        for (int[] is : g.get(0)) {
            heap.add(is);
        }
        isvisit[0] = true;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] cp = heap.poll();
            int idx = cp[0];
            if (isvisit[idx]) {
                i--;
                continue;
            }
            int dist = cp[1];
            isvisit[idx] = true;
            ans += dist;
            for (int[] is : g.get(idx)) {
                if (!isvisit[is[0]]) {
                    // 没有被访问过
                    heap.add(is);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        minCostConnectPoints m = new minCostConnectPoints();
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(m.MinCostConnectPoints(points));
    }
}