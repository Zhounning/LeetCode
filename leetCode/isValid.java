package leetCode;

import java.util.HashMap;
/**
 * IsValid
 * 2020-07-04 重做
 */
import java.util.Stack;
public class isValid {

//     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/valid-parentheses
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 // Hash table that takes care of the mappings.

    private HashMap<Character, Character> mappings;
    
    //括号匹配，比较简单，直接使用栈进行判断即可
    public boolean IsValid(String s) {
        if(s==null||s.length()==0) return true;
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
        Stack<Character> charStack = new Stack<>();
       
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (this.mappings.containsKey(ch)) {
                char topElement = charStack.empty() ? '#' : charStack.pop();
                if (topElement != this.mappings.get(ch)) {
                    return false;
                }

            }else{
                charStack.push(ch);                
            }
        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        isValid i =new isValid();
        String s = "()";
        System.out.println(i.IsValid(s));
    }
}