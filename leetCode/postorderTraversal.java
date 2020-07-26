package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * postorderTraversal
 */
public class postorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> PostorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }
}
