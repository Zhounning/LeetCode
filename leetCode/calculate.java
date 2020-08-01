package leetCode;

import java.util.HashMap;
import java.util.Stack;

public class calculate {

    // 在栈里面优先级
    HashMap<Character, Integer> isp = new HashMap<>();
    // 在栈外面优先级
    HashMap<Character, Integer> icp = new HashMap<>();

    public int Calculate(String s) {
        // 在栈里面
        isp.put('(', 1);
        isp.put(')', 6);
        isp.put('+', 3);
        isp.put('-', 3);
        isp.put('#', 0);
        // 在栈外面
        icp.put('(', 6);
        icp.put(')', 1);
        icp.put('+', 2);
        icp.put('-', 2);

        // 数字栈，存数字
        Stack<Integer> numStack = new Stack<>();
        // 符号栈存储符号
        Stack<Character> signStack = new Stack<>();
        // 去掉空格
        s = s.replace(" ", "");
        signStack.push('#');
        // char [] chars = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                // 如果是数字，则压入数字栈
                numStack.push(Integer.valueOf(s.substring(i, j)));
                i = j;
            } else {
                // 说明是符号
                char sign = signStack.peek();

                if (isp.get(sign) == icp.get(ch)) {
                    // 说明一个是左括号，一个是右括号
                    signStack.pop();
                    ++i;
                } else if (isp.get(sign) < icp.get(ch)) {
                    // 说明栈里面的优先级小于栈外面的优先级
                    signStack.push(ch);// 进栈
                    ++i;
                } else {
                    // 说明栈里面的优先级大于栈外面的优先级
                    // 则需要出栈进行计算
                    signStack.pop();
                    int a = numStack.pop();
                    int b = numStack.pop();
                    if (sign == '+') {
                        numStack.push(a + b);
                    } else {
                        numStack.push(b - a);
                    }
                }
            }
        }
        // 防止出现类似于1+1的情况，导致没有进行计算
        while (signStack.size() > 1) {
            char sign = signStack.pop();
            int a = numStack.pop();
            int b = numStack.pop();
            if (sign == '+') {
                numStack.push(a + b);
            } else {
                numStack.push(b - a);
            }
        }
        return numStack.peek();
    }

    public static void main(String[] args) {
        calculate c = new calculate();
        String s = "2147483647";
        System.out.println(c.Calculate(s));
    }

}