package leetCode.offer;

import java.util.LinkedList;
import java.util.Queue;

import leetCode.TreeNode;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "*";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (sb.length() > 0) {
                sb.append(",");
            }
            if (p != null) {
                sb.append(p.val);
                queue.add(p.left);
                queue.add(p.right);
            } else {
                sb.append("*");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("*")) {
            return null;
        }

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (!arr[i].equals("*")) {
                p.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(p.left);
            } 

            i++;
            if (!arr[i].equals("*")) {
                p.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(p.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(1);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));

    }
}