package leetCode.offer;

import java.util.Stack;

/**
 * validateStackSequences
 */
public class validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;

        while (i != pushed.length || j != pushed.length) {
            boolean ischange = false;

            while (i != pushed.length && (stack.isEmpty() || stack.peek() != popped[j])) {
                stack.push(pushed[i]);
                i++;
                ischange = true;
            }

            while (j != popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
                ischange = true;
            }

            if (!ischange) {
                break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        validateStackSequences v = new validateStackSequences();
        int[] pushed = { 1, 0 };
        int[] popped = { 1, 0 };
        System.out.println(v.validateStackSequences(pushed, popped));
    }
}