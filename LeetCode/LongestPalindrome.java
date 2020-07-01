package leetCode;
/**
 * LongestPalindrome
 */
public class LongestPalindrome {
    // 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //开始的方法
    public String longestPalindrome(String s) {

        if(s==null||s.length()==0)//特殊情况判断
            return "";

        int strLength = s.length(); //得到长度
        //通过二维数组进行dp
        boolean F[][] =new boolean [strLength][strLength];  
        for(int i=0;i<strLength;i++){
             F[i] = new boolean[strLength];
        } 
        String res = null;
        int maxSubLength = 0;

        //初始化所有一字母和二字母
        for(int i=0;i<strLength;i++){
            F[i][i] =true;


            if(i+1<strLength&&s.charAt(i)==s.charAt(i+1)){
                F[i][i+1]=true;
                if(2>maxSubLength){
                    maxSubLength = 2;
                    res = s.substring(i, i+2);
                }
            }
            if(maxSubLength<1){
                maxSubLength = 1;
                res = s.substring(i,i+1);
            }
        }
       
        for(int j=2;j<strLength;j++){
            for(int i=0;i<strLength;i++){
                if((i+j)<strLength){
                    if(F[i+1][i+j-1]==true && s.charAt(i+j)==s.charAt(i)){
                        F[i][i+j]=true;
                        if(j+1>maxSubLength){
                            maxSubLength = j+1;
                            res = s.substring(i, i+j+1);
                        }

                    }else{
                        F[i][i+j]=false;
                    }
                }
            }
        }
        return res;
    }

    //学习别人改进的方法，进行倒叙的遍历，有奇效
    public String longestPalindrome2(String s) {
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
    public static void main(String[] args) {
        LongestPalindrome l =new LongestPalindrome();
        String s = "cbbd";
        System.out.println(l.longestPalindrome2(s));
    }




}