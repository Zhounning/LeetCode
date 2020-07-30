
package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * findOrder
 */
public class findOrder {
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
        // 入度矩阵
        int[] inDegrees = new int[numCourses];
        // 邻居矩阵
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            // 课程cp[0]的入度增加
            inDegrees[cp[0]]++;
            // 由cp[1]->cp[0]
            adj.get(cp[1]).add(cp[0]);
        }
        // 进行宽度优先遍历
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 课程顺序
        int[] order = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order[i] = pre;
            i++;
            numCourses--;

            // 将他的邻居的入度减一
            for (int j : adj.get(pre)) {
                if (--inDegrees[j] == 0)
                    queue.add(j);
            }
        }

        return numCourses==0 ? order : new int[0];
    }

    public static void main(String[] args) {
        findOrder f = new findOrder();
        int numCourses = 4;
        int[][] prerequisites = new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 },
                new int[] { 3, 2 } };
        System.out.println(Arrays.toString(f.FindOrder(numCourses, prerequisites)));
    }

}