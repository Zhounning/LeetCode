package leetCode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    List<String> res = null;

    public List<String> LetterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits != null && digits.length() > 0) {
            char[] array = new char[digits.length()];
            dfs(digits, array, 0);
        }
        return res;
    }

    void dfs(String digits, char[] array, int index) {
        if (index == array.length) {
            res.add(String.valueOf(array));
            return;
        }
        char[] repos = getValues(digits.charAt(index));
        for (int j = 0; j < repos.length; j++) {
            array[index] = repos[j];
            dfs(digits, array, index + 1);
        }

    }

    char[] getValues(char ch) {
        switch (ch) {
            case '2':
                return new char[] { 'a', 'b', 'c' };
            case '3':
                return new char[] { 'd', 'e', 'f' };
            case '4':
                return new char[] { 'g', 'h', 'i' };
            case '5':
                return new char[] { 'j', 'k', 'l' };
            case '6':
                return new char[] { 'm', 'n', 'o' };
            case '7':
                return new char[] { 'p', 'q', 'r', 's' };
            case '8':
                return new char[] { 't', 'u', 'v' };
            case '9':
                return new char[] { 'w', 'x', 'y', 'z' };
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) {
        letterCombinations l = new letterCombinations();
        String digits = "23";
        System.out.println(l.LetterCombinations(digits));
    }
}