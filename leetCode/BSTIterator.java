package leetCode;

import java.util.LinkedList;
import java.util.Stack;

class BSTIterator {

    LinkedList<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                queue.addLast(p.val);
                p = p.right;
            }
        }

    }

    /** @return the next smallest number */
    public int next() {
        return queue.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next()); // 返回 3
        System.out.println(iterator.next()); // 返回 7

    }
}
