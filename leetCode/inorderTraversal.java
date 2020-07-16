package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class inorderTraversal {
    public List<Integer> InorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p!=null|| !stack.isEmpty()) {
            while (p!=null) {
                stack.push(p);
                p=p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                res.add(p.val);
                p=p.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        inorderTraversal i = new inorderTraversal();
        System.out.println(i.InorderTraversal(root));
    }
}