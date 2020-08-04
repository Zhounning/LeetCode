package leetCode;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {

    public List<String> BinaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        if (root == null) {
            return path;
        }

        if (root.left == null && root.right == null) {
            // 说明是叶子节点
            path.add(String.valueOf(root.val));
            return path;
        }

        List<String> left = BinaryTreePaths(root.left);
        List<String> right = BinaryTreePaths(root.right);

        for (String s : left) {
            path.add(root.val + "->" + s);
        }

        for (String s : right) {
            path.add(root.val + "->" + s);
        }

        return path;
    }

    public static void main(String[] args) {
        binaryTreePaths b = new binaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(b.BinaryTreePaths(root));
    }

}