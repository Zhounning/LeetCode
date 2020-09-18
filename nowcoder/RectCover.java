package nowcoder;

public class RectCover {
    public int rectCover(int target) {
        if (target==0) {return 0;}

        if(target==1){return 1;}

        int a = 1;
        int b= 1;
        int res = 0;
        for (int i = 1; i < target; i++) {
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }
}