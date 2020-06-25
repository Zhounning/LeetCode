package niuke;

import java.util.HashMap;

public class TreeDepth {
     
    public int treeDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right)+1;
    }
}