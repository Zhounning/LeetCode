package leetCode;

public class sumNumbers {
    int res = 0;
    public int SumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void  dfs(TreeNode root,int num){
        if (root==null) {
            return;
        }
        
        num = num +root.val;
        if (root.left==null && root.right==null) {
            res+=num;
        }

        dfs(root.left,num*10);
        dfs(root.right,num*10);
    }

    public static void main(String[] args) {
        sumNumbers s = new sumNumbers();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        System.out.println(s.SumNumbers(root));
    }
}