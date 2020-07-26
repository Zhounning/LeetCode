package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class preorderTraversal {
    public List<Integer> PreorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode p = stack.pollLast();
            if (p != null) {
                res.add(p.val);
                stack.add(p.right);
                stack.add(p.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        preorderTraversal p = new preorderTraversal();
        System.out.println(p.PreorderTraversal(root));
    }
}