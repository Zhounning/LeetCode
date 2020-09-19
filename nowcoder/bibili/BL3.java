package nowcoder.bibili;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BL3 {

    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('#', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        while (sc.hasNext()) {
            String s =sc.nextLine();
            if (s.equals("END")) {
                break;
            }
            res.add(f(s));
        }
        for (Integer integer : res) {
            System.out.println(integer);
        }
        // System.out.println(f(s));
    }

    public static int f(String s) {
        // 数字栈
        Stack<Integer> numStack = new Stack<>();
        // 符号栈
        Stack<Character> chStack = new Stack<>();
        s = s + "#";
        int i = 0;
        int start = 0;
        while (i < s.length()) {
            Character ch = s.charAt(i);
            // 说明是符号
            if (map.containsKey(ch)) {
                String str = s.substring(start, i);
                numStack.push(Integer.valueOf(str));
                start = i + 1;
                while (!chStack.isEmpty() && map.get(ch) <= map.get(chStack.peek())) {
                    int a = numStack.pop();
                    int b = numStack.pop();
                    Character op = chStack.pop();
                    if (op == '+') {
                        numStack.push(a + b);
                    } else if (op == '-') {
                        numStack.push(b - a);
                    } else if (op == '*') {
                        numStack.push(a * b);
                    } else {
                        numStack.push(b / a);
                    }
                }
                chStack.push(ch);
            }
            i++;
        }
        return numStack.peek();
    }
}