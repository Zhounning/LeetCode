package niuke;

import java.util.Arrays;

public class offer6 {

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null)
            return null;
        
        if(in.length==0)
            return null;    
        
       int index = -1;
       int i = 0;
    //    for(;i<pre.length;i++){
            
    //         if (index>=0) {
    //             break;
    //         }
    //    }
        for (int j = 0; j < in.length; j++) {
            if(in[j]==pre[0])
            {
                index = j;
                break;
            }
        }
       if (index<0) {
          return null; 
       }

       int []leftpre = Arrays.copyOfRange(pre, 1, 1+index);
       int []rightpre = Arrays.copyOfRange(pre, 1+index,pre.length);
       int []leftin = Arrays.copyOf(in, index);
       int []rightin = Arrays.copyOfRange(in,index+1,in.length); 
       TreeNode parent = new TreeNode(pre[i]);
       parent.left = reConstructBinaryTree(leftpre,leftin);
       parent.right = reConstructBinaryTree(rightpre,rightin);
       return parent;
    }

    public static void main(String[] args) {
        int pre[] = new int[] {1,2,3,4,5,6,7};
        int in[] = new int[] {3,2,4,1,6,5,7};
        reConstructBinaryTree(pre,in);
    }

}