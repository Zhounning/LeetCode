package niuke.bibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BL2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = 7;
        int n = sc.nextInt();
        int a = sc.nextInt();
        int edgesNum = sc.nextInt();
        // 图
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // int edges[][] = new int[edgesNum][2];
        // int edges[][] = { { 1, 0 }, { 3, 1 }, { 4, 1 }, { 5, 3 }, { 6, 1 }, { 6, 5 }
        // };
        for (int i = 0; i < edgesNum; i++) {
            String s = sc.next();
            String[] e = s.split(",");
            int e1 = Integer.valueOf(e[0]);
            int e2 = Integer.valueOf(e[1]);
            g.get(e1).add(e2);
            g.get(e2).add(e1);
        }

        boolean isVisit[] = new boolean[n];
        // isVisit[a] = true;
        // 已经有的朋友数量
        int b = g.get(a).size();
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(a);

        while (!stack.isEmpty()) {
            Integer i = stack.pop();
            if (!isVisit[i]) {
                res++;
                isVisit[i] = true;
                for (Integer j : g.get(i)) {
                    stack.push(j);
                }
            }
        }
        System.out.println(res - b - 1);

    }
}