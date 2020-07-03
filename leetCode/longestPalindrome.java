package leetCode;
/**
 * 2020-07-02 重做
 */
public class longestPalindrome {
  
    //采用动态规划
    public String LongestPalindrome(String s) {
        if(s==null || s.length()<=0) return "";
        boolean [][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i] = new boolean[s.length()];
            isPalindrome[i][i] = true;
        }

        int maxLength = 1;
        String res = s.substring(0, 1);
        //外层表示回文串的个数
        for (int i = 1; i < isPalindrome.length; i++) {
            //内层遍历
            for (int j = 0; j+i < isPalindrome.length; j++) {
                
                isPalindrome[j][j+i] = s.charAt(j)==s.charAt(j+i) && (i<=1 || isPalindrome[j+1][j+i-1]);
                if (isPalindrome[j][j+i] && i+1>maxLength) {
                    res = s.substring(j,j+i+1);
                }
            }
        }
        return res;
    }

    //动态规划，但是使用一维的数组解决了问题
    //时间上没有减少，但是空间上节约很多，妙阿
    public String LongestPalindrome2(String s) {
        int n = s.length();
		String res = "";
		boolean[] P = new boolean[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
				P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
				if (P[j] && j - i + 1 > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
    }

    //方法二的改造版
    public String LongestPalindrome3(String s) {
        int n = s.length();
		String res = "";
		boolean[] P = new boolean[n];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<=i; j++) {
				P[j] = s.charAt(i) == s.charAt(j) && (i - j< 3 || P[j +1]);
				if (P[j] && i - j + 1 > res.length()) {
					res = s.substring(j, i+ 1);
				}
			}
		}
		return res;
    }



    public static void main(String[] args) {
        longestPalindrome l =new longestPalindrome();
        String s = "babad";
        System.out.println(l.LongestPalindrome3(s));
    }


}