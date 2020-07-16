package leetCode;

import java.util.ArrayList;
import java.util.List;

public class grayCode {
    public List<Integer> GrayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            ret.add(i ^ i>>1);
        return ret;
    }
}