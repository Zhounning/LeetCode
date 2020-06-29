package niuke;

import java.util.ArrayList;
import java.util.LinkedList;

public class Print2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res =new ArrayList<>();
        if (pRoot==null) {
            return res;
        }
        //队列形式
        LinkedList<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(pRoot);
        int nextLevel = 0;
        int toBePrinted = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!treeQueue.isEmpty()) {
            TreeNode p =treeQueue.pop();
            temp.add(p.val);
            if(p.left!=null){
                treeQueue.add(p.left);
                ++nextLevel;
            }
            
            if(p.right!=null){
                treeQueue.add(p.right);
                ++nextLevel;
            }
            --toBePrinted;

            if (toBePrinted==0) {
                
                res.add(temp);
                temp = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
}