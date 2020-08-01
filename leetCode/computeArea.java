package leetCode;

public class computeArea {

    public int ComputeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if (C <= E || F >= D || B >= H || A >= G) {
            return area1 + area2; // 无重叠
        }
        int topX = Math.min(G, C);
        int topY = Math.min(H, D);
        int bottomX = Math.max(E, A);
        int bottomY = Math.max(B, F);
        return area1 - (topX - bottomX) * (topY - bottomY) + area2;
    }
}