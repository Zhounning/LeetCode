package leetCode;

public class reverse {
    public int Reverse(int x) {

        long res = 0;

        while (x!=0) {
            if(res*10+(x%10)>=Integer.MAX_VALUE||res*10+(x%10)<=Integer.MIN_VALUE) {
                return 0;
            }
            res=res*10+(x%10);
            x=x/10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        reverse r = new reverse();
        System.out.println(r.Reverse(1534236469));
    }
}