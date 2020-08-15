package leetCode;

public class TreeAncestor {
    int n;
    int[] parent;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
    }

    public int getKthAncestor(int node, int k) {

        // 表示父节点
        int p = 0;
        while (k > 0) {
            if (node == -1) {
                return -1;
            }

            p = parent[node];
            node = p;

            k--;
        }
        return node;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] parent = { -1, 0, 0, 1, 1, 2, 2 };
        TreeAncestor t = new TreeAncestor(n, parent);
        System.out.println(t.getKthAncestor(3, 1));
        System.out.println(t.getKthAncestor(5, 2));
        System.out.println(t.getKthAncestor(6, 3));
    }
}