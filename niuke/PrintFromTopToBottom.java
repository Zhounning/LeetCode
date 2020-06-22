package niuke;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        // if (root==null) {
        //     return null;
        // }
        LinkedList<TreeNode> TreeQueue = new LinkedList<>();
        TreeQueue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode p =null;
        while (!TreeQueue.isEmpty()) {
            p=TreeQueue.pop();

            if (p!=null) {
                res.add(p.val);
                TreeQueue.add(p.left);
                TreeQueue.add(p.right);
            }
        }
        return res;
    }
}