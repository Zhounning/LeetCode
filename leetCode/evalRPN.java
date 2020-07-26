package leetCode;

import java.util.LinkedList;

/**
 * evalRPN
 */
public class evalRPN {

    public int EvalRPN(String[] tokens) {

        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            int a, b;
            switch (token) {
                case "+":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(a + b);
                    break;
                case "-":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b - a);
                    break;
                case "*":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(a * b);
                    break;
                case "/":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b / a);
                    break;
                default:
                    stack.addLast(Integer.valueOf(token));
                    break;
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        evalRPN e = new evalRPN();
        String[] tokens = { "4", "13", "5", "/", "+" };
        System.out.println(e.EvalRPN(tokens));
    }
}