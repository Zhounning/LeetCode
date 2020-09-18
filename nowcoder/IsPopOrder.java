package nowcoder;


import java.util.Stack;

public class IsPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA==null||popA==null) {
            return false;
        }

        if (pushA.length!=popA.length) {
            return false;
        }
        boolean res = true;
        int i = 0;
        int j = 0;
        Stack<Integer> myStack = new Stack<>();
        // myStack.push(pushA[0]);

        while (true) {
            
            while(!myStack.isEmpty()&&i<popA.length&&myStack.peek()==popA[i]) {
                myStack.pop();
                i++;
            }

            if (j<pushA.length) {
                myStack.push(pushA[j++]);
            }else{
                if (myStack.isEmpty()&&i==popA.length) {
                    res=true;
                }else{
                    res = false;
                }
                break;
            }
        }

        return res;
    }
}