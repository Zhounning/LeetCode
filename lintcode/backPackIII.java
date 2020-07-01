package lintcode;

public class backPackIII {
      /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int BackPackIII(int m, int[] A, int[] V) {
        // write your code here

        if(A==null||A.length<=0||V==null||V.length<=0||A.length!=V.length||m<=0){
            return 0;
        }

        //容量
        int []dp = new int[m+1];


        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <dp.length; j++) {
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);      
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        backPackIII b = new backPackIII();
        int m=10;
        int[]A = {2,3,5,7};
        int[]V = {2,5,2,4};
        System.out.println(b.BackPackIII(m,A,V));
    }

}