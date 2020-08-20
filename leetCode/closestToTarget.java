package leetCode;

import java.util.Arrays;

public class closestToTarget {
    int[] nums;
    Node[] tree;
    int n;

    class Node {
        int l, r;
        int data;
    };

    void build(int k, int l, int r) {
        tree[k].l = l;
        tree[k].r = r;
        if (l == r) {
            tree[k].data = nums[l];
        } else {
            // m则为中间点，左儿子的结点区间为[l,m],右儿子的结点区间为[m+1,r]
            int m = l + ((r - l) >> 1);
            // l = fa*2 （左子树下标为父亲下标的两倍）
            build(k << 1, l, m); // 递归构造左儿子结点
            // r = fa*2+1（右子树下标为父亲下标的两倍+1）
            build(k << 1 | 1, m + 1, r); // 递归构造右儿子结点
            // 进行 &运算
            tree[k].data = tree[k << 1].data & tree[k << 1 | 1].data;
        }
    }

    // 查询,u为需要查询的下标,l,r为范围
    int query(int u, int l, int r) {
        if (l <= tree[u].l && r >= tree[u].r)
            return tree[u].data;
        int mid = tree[u].l + tree[u].r >> 1;
        int ans = (1 << 30) - 1;
        if (l <= mid)
            ans = ans & (query(u << 1, l, r));
        if (r > mid)
            ans = ans & (query(u << 1 | 1, l, r));
        return ans;
    }

    public int ClosestToTarget(int[] arr, int target) {
        n = arr.length;
        nums = new int[n + 1];
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }
        // 建树
        build(1, 1, n);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int l = i - 1, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                int t = query(1, i, mid);
                if (t == target)
                    return 0;
                else if (t > target)
                    l = mid;
                else
                    r = mid - 1;
            }
            if (l == i - 1)
                ans = Math.min(ans, Math.abs(nums[l] - target));
            else if (l == n) {
                ans = Math.min(ans, Math.abs(query(1, i, n) - target));
            } else {
                ans = Math.min(ans, Math.abs(query(1, i, l) - target));
                ans = Math.min(ans, Math.abs(query(1, i, l + 1) - target));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        closestToTarget c = new closestToTarget();
        int[] arr = { 1000000, 1000000, 1000000 };
        int target = 1;
        System.out.println(c.ClosestToTarget(arr, target));
    }
}