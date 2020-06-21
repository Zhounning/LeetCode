package niuke;

public class Power {
    public double power(double base, int exponent) {
        return dfs(base, exponent);
    }

    public double dfs(double base, int exponent){
        if (exponent==0) {
            return 1.0;
        }

        int absexponent =0;
        //判断正负
        if(exponent>0){
            absexponent = exponent;
        }else{
            absexponent=-exponent;
        }
        double res = 0.0;

        res = dfs(base, absexponent/2);
        res = res*res;
        if (absexponent%2!=0) {   
           res = res*base;
        }

        if (exponent<0) {
            res = 1.0/res;
        }
        return res;

    }
}