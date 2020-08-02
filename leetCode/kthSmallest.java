package leetCode;

import java.util.Stack;

public class kthSmallest {
    //迭代K
    public int KthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                --k;
                if (k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }

}