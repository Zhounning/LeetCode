package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * addOperators
 */
public class addOperators {
    
    public List<String> addOperators(String num, int target) {
        return dfs(num, 0, target);
    }

    private List<String> dfs(String num, int cur, int target) {
        
    }

    public static void main(String[] args) {
        addOperators a = new addOperators();
        String num = "123";
        int target = 6;
        System.out.println(a.addOperators(num, target));
    }

}