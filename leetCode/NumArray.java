package leetCode;

/**
 * NumArray 使用树状数组完成
 */
public class NumArray {
    int[] nums;
    int[] tree;
    int n;

    int lowbit(int x) {
        return x & (-x);
    }

    int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    void add(int x, int c) {
        // nums[x] += c;
        while (x <= n) {
            tree[x] += c;
            x += lowbit(x);
        }
    }

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray n = new NumArray(nums);
        System.out.println(n.sumRange(0, 2));
        n.update(1, 2);
        System.out.println(n.sumRange(0, 2));
    }
}
