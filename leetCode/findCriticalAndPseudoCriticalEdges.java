package leetCode;

import java.util.List;

/**
 * findCriticalAndPseudoCriticalEdges
 */
public class findCriticalAndPseudoCriticalEdges {

    /**
     * upSet 并查集
     */
    public class upSet {
        int[] p;

        public upSet(int size) {
            p = new int[size];
            // 指向自己
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }

        public int Find(int x) {
            int r = x;
            while (r != p[r]) {
                r = p[r];
            }
            // 进行路径压缩
            int i = x, j;
            while (i != r) {
                j = p[i];
                p[i] = r;
                i = j;
            }
            return r;
        }

        public void joint(int x, int y) {
            int fx = Find(x);
            int fy = Find(y);
            // 分支合并
            if (fx != fy) {
                p[fx] = fy;
            }
        }

    }

    public List<List<Integer>> FindCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

    }
}