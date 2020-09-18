package nowcoder;

/**
 * Serialize
 */
import java.util.Stack;
public class serialize {
    int p = 0;
    public String Serialize(TreeNode root) {
        if (root==null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.add(root);

        while (!treeStack.isEmpty()){
            TreeNode p = treeStack.pop();
            if(p==null){
                res.append('#');

            }else{
                res.append(p.val);
                res.append('!');
                treeStack.add(p.right);
                treeStack.add(p.left);
            }
        }
            
        return res.toString();
    }
    
    public TreeNode Deserialize(String str) {
        if (str==null || str.length()<=0) {
             return null;
        }

        if (str.charAt(p)=='#') {
            p++;
            return null;
        }

        int start = p;
        while (str.charAt(p)!='!') {
            p++;
        }
        String s = str.substring(start,p);
        
        TreeNode root = new TreeNode(Integer.valueOf(s));
        p++;
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode pleft = new TreeNode(2);
        pleft.left = new TreeNode(4);
        pleft.right = new TreeNode(5);
        TreeNode pright = new TreeNode(3);
        pright.left  = new TreeNode(6);
        pright.right  = new TreeNode(7);
        root.left = pleft;
        root.right = pright;
        serialize s = new serialize();
        String str = s.Serialize(root);
        System.out.println( str);
        TreeNode p =s.Deserialize(str);
        System.out.println(p.val);
    }
   
}