package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class canFinish {
    public boolean CanFinish(int numCourses, int[][] prerequisites) {
        // 入度矩阵
        int[] inDegrees = new int[numCourses];
        // 邻接矩阵
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
            // 由 点1指向点0
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++)
            if (inDegrees[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--inDegrees[cur] == 0)
                    queue.add(cur);
        }
        return numCourses == 0;
    }
}