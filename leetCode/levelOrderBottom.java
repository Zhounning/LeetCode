package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrderBottom {
    public List<List<Integer>> LevelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root==null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode p =queue.pop();
            temp.add(p.val);
            toBePrinted--;

            if (p.left!=null) {
                queue.add(p.left);
                nextLevel++;
            }

            
            if (p.right!=null) {
                queue.add(p.right);
                nextLevel++;
            }

            //说明这一层打印完毕
            if (toBePrinted==0) {
                //头插法
                res.addFirst(temp);
                temp =new ArrayList<>(); 
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

        return res;
    }
}