package leetCode;

public class findLatestStep {
    int[] p;
    int[] family_num;

    int find(int x) {
        int r = x;
        while (p[r] != r) {
            r = p[r];
        }

        int i = x, j;
        // 路径压缩
        while (i != r) {
            j = p[i];
            p[i] = r;
            i = p[i];
        }
        return r;
    }

    void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        p[fx] = fy;
        family_num[fx] += p[fy];
        family_num[fy] += p[fx];
    }

    public int FindLatestStep(int[] arr, int m) {
        
    }
}