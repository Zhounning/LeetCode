package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * zigzagLevelOrder
 */
public class zigzagLevelOrder {

    public List<List<Integer>> ZigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if (root==null) {
            return res;
        }
        //表示层数
        // int level = 1;
        Stack<TreeNode> treeStack0 = new Stack<>(); //表示偶数层
        Stack<TreeNode> treeStack1 = new Stack<>();//表示奇数层
        treeStack1.add(root);

        while (!treeStack1.isEmpty() || !treeStack0.isEmpty()) {
            TreeNode p =null;
            ArrayList<Integer> temp = new ArrayList<>();

            while (!treeStack1.isEmpty()) {
                p=treeStack1.pop();
                temp.add(p.val);
                if(p.left!=null)treeStack0.add(p.left);
                if(p.right!=null)treeStack0.add(p.right);
            }

            if (!temp.isEmpty()) {
                res.add(temp);
                temp = new ArrayList<>();
            }

            while (!treeStack0.isEmpty()) {
                p=treeStack0.pop();
                temp.add(p.val);
                if(p.right!=null)treeStack1.add(p.right);
                if(p.left!=null)treeStack1.add(p.left);
            }

            if (!temp.isEmpty()) {
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode pleft = new TreeNode(2);
        pleft.left = new TreeNode(4);
        pleft.right = new TreeNode(5);
        TreeNode pright = new TreeNode(3);
        // pright.left  = new TreeNode(6);
        pright.right  = new TreeNode(7);
        root.left = pleft;
        root.right = pright;
        zigzagLevelOrder p = new zigzagLevelOrder();
        List<List<Integer>>res =  p.ZigzagLevelOrder(root);
        System.out.println(res);
    }
}