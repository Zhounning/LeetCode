package nowcoder;

import java.util.Stack;

public class minStack {
    private Stack<Integer> mystack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();

    public void push(int node) {
        mystack.push(node);
        //判断最小值的push
        if (minstack.isEmpty()) {
            minstack.push(node);
        } else {
            if (node<=minstack.peek()) {
                minstack.push(node);
            }
        }

    }
    
    public void pop() {
        if (!mystack.isEmpty()) {
            int res = mystack.pop();
            if (res==minstack.peek()) {
                minstack.pop();
            }
        }
    }
    
    public int top() {
        //这里如果为空很不好处理，不知道乍整
       try {
           int res =  mystack.peek();
           return res;
       } catch (Exception e) {
           //TODO: handle exception
            e.printStackTrace();
        }

        return mystack.peek();
    }
    
    public int min() {
        return minstack.peek();
    }
}