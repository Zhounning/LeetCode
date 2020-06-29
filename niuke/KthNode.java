package niuke;

import java.util.Stack;

public class KthNode {
    
    TreeNode kthNode(TreeNode pRoot, int k)
    {   
        Stack<TreeNode> treeStack = new Stack<>();
        // treeStack.add(pRoot);
        TreeNode p =pRoot;
        while (p!=null||!treeStack.isEmpty()) {
            
            while (p!=null) {
                treeStack.add(p);
                p = p.left;
            }

            if (!treeStack.isEmpty()) {
                p = treeStack.pop();
                k--;
                if (k==0) {
                    return p;
                }
                p = p.right;
            }

        }
        return null;
    }
}