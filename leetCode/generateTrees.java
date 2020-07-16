package leetCode;

import java.util.LinkedList;
import java.util.List;

public class generateTrees {
    public List<TreeNode> GenerateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
          }
          return generate_trees(1, n);
    }

    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
          all_trees.add(null);
          return all_trees;
        }
    
        // 选择一个作为根
        for (int i = start; i <= end; i++) {
          //可能的左子树
          LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
    
          // 可能的右子树
          LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
    
          // 两者联系起来
          for (TreeNode l : left_trees) {
            for (TreeNode r : right_trees) {
              TreeNode current_tree = new TreeNode(i);
              current_tree.left = l;
              current_tree.right = r;
              all_trees.add(current_tree);
            }
          }
        }
        return all_trees;
      }

}