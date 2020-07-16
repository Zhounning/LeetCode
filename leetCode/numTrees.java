package leetCode;

public class numTrees {
    // 从 i 划分
    //分为 1->(i-1) * (i+1)->n种
    public int NumTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        //第一层循环表示长度
        for (int i = 2; i <= n; ++i) {
            //第二层循环表示 根从那个开始
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}