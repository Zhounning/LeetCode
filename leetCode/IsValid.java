package leetCode;
/**
 * IsValid
 */
import java.util.Stack;
public class IsValid {

//     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/valid-parentheses
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //括号匹配，比较简单，直接使用栈进行判断即可
    public boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;

        Stack<Character> myStack = new Stack<>();

        int i=0;
        //myStack.add(s.charAt(i));

        while(i<s.length()){
            if(!myStack.empty()){
                switch(myStack.peek()){
                    case '(':
                    if(s.charAt(i)==')'){
                        myStack.pop();
                    }else{
                        myStack.add(s.charAt(i));
                    }
                    break;
    
                    case '[':
                    if(s.charAt(i)==']'){
                        myStack.pop();
                    }else{
                        myStack.add(s.charAt(i));
                    }
                    break;
    
                    case '{':
                    if(s.charAt(i)=='}'){
                        myStack.pop();
                    }else{
                        myStack.add(s.charAt(i));
                    }
                    break;
                }
            }else{
                myStack.add(s.charAt(i));
            }
            i++;
        }

        return myStack.empty();
    }


}