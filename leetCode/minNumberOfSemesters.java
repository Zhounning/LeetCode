package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class minNumberOfSemesters {
    /**
     * Node
     */
    public class Node {
        int i;// 表示序号
        List<Node> link;
        // 表示在图中的第几层
        int kNum;

        public Node(int _i, List<Node> _link) {
            i = _i;
            link = _link;
            kNum = 1;
        }

    }

    public int MinNumberOfSemesters(int n, int[][] dependencies, int k) {
        // 入度矩阵
        int[] inDegrees = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Node[] nodes = new Node[n];
        int res = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, new ArrayList<>());
        }

        for (int i = 0; i < dependencies.length; i++) {
            // 入度加1
            inDegrees[dependencies[i][1] - 1]++;
            // 进行指向
            nodes[dependencies[i][0] - 1].link.add(nodes[dependencies[i][1] - 1]);
            // 设置第几层
            nodes[dependencies[i][1] - 1].kNum = Math.max(nodes[dependencies[i][1] - 1].kNum,
                    nodes[dependencies[i][0] - 1].kNum + 1);
        }

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        int next = 0;

        // 深度优先遍历
        while (!queue.isEmpty()) {
            // 入度为0的节点的下标
            int i = queue.poll();
            count--;
            j++;
            for (Node cur : nodes[i].link) {
                if (--inDegrees[cur.i] == 0) {
                    queue.add(cur.i);
                    // 下一层的数量
                    next++;
                }
            }

            if (count == 0) {
                res++;
                count = next;
                next = 0;
                j = 0;
            }

            // 需要加一个学期
            if (j == k) {
                res++;
                j = 0;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int n = 11;
        int[][] dependencies1 = { { 2, 1 }, { 3, 1 }, { 1, 4 } };
        int[][] dependencies2 = { { 2, 1 }, { 3, 1 }, { 4, 1 }, { 1, 5 } };
        int[][] dependencies3 = { };
        int k = 2;

        minNumberOfSemesters m = new minNumberOfSemesters();
        System.out.println(m.MinNumberOfSemesters(n, dependencies3, k));
    }
}