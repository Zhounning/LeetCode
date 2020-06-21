package niuke;

/**
 * JumpFloor
 */
public class JumpFloor {

    public int jumpFloor(int target) {
        if (target==0) {return 0;}

        if(target==1){return 1;}

        int res = 1;
        for (int i = 1; i < target; i++) {
            res = res*2;
        }

        return res;
    }
}