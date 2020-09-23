package leetCode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetCode.TreeNode;

public class levelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            ans.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }

        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        int i = 1;
        int j = 0;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            temp.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
                j++;
            }
            if (p.right != null) {
                queue.add(p.right);
                j++;
            }
            i--;

            if (i == 0) {
                ans.add(temp);
                temp = new ArrayList<>();
                i = j;
                j = 0;
            }
        }
        return ans;
    }

    // 第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode p = queue.poll();
                if (ans.size() % 2 == 0) {
                    temp.addLast(p.val);
                } else {
                    temp.addFirst(p.val);
                }
                if (p.left != null)
                    queue.add(p.left);
                if (p.right != null)
                    queue.add(p.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}