package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class minInteger {
    char[] arr;

    // 贪心思想：越小，越往前换越好
    public String MinInteger(String num, int k) {

        arr = num.toCharArray();
        exchange(0, k);
        return new String(arr);
    }

    // 先使用递归
    void exchange(int start, int k) {
        if (k == 0) {
            return;
        }

        if (start == arr.length - 1) {
            return;
        }
        // 交换使用的次数
        int index = start;
        char ch = '9';
        for (int i = start; i < arr.length; i++) {
            // 说明后面交换不到了
            if (i - start > k) {
                break;
            }

            if (ch > arr[i]) {
                ch = arr[i];
                index = i;
            }
        }

        // 将位置进行移动
        for (int i = index; i >= start + 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = ch;
        exchange(start + 1, k - (index - start));
    }

    // 使用线段树
    public String minInteger2(String num, int k) {
        int n = num.length();
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[num.charAt(i) - '0'].offer(i + 1);
        }
        StringBuffer ans = new StringBuffer();
        BIT bit = new BIT(n);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (!pos[j].isEmpty()) {
                    int behind = bit.query(pos[j].peek() + 1, n);
                    int dist = pos[j].peek() + behind - i;
                    if (dist <= k) {
                        bit.update(pos[j].poll());
                        ans.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        public int query(int x, int y) {
            return query(y) - query(x - 1);
        }
    }

    public static void main(String[] args) {
        minInteger m = new minInteger();
        String num = "4321";
        int k = 4;
        System.out.println(m.minInteger2(num, k));
    }

}