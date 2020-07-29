package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * rightSideView
 */
public class rightSideView {

    List<Integer> res = new ArrayList<>();

    public List<Integer> RightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }

        if (res.size() <= index) {
            res.add(root.val);
        }

        dfs(root.right, index + 1);
        dfs(root.left, index + 1);
    }

    public static void main(String[] args) {
        rightSideView r = new rightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(r.RightSideView(root));
    }
}