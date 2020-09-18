package nowcoder;

public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0) {
            return false;
        }
        return dfs(sequence,0,sequence.length-1);
    }
    
    public boolean dfs(int [] sequence,int start,int end){
        int root = sequence[end];
        int i=start;
        //寻找左子树
        for (; i < end; i++) {
            if (sequence[i]>root) {
                break;
            }
        }

        //在二叉树的右子树中寻找值大于根本节点的值
        int j=i;
        for (; j< end; j++) {
            if (sequence[j]<root) {
                return false;
            }
        }
        //判断左子树是否是二叉搜索树
        boolean left = true;
        if (i>start) {
                left = dfs(sequence, start,i-1);
        }

        boolean right=true;
        if (i<end) {
            right = dfs(sequence,i, end-1);
        }
        return left && right;
    }
}