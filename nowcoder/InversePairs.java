package nowcoder;

public class InversePairs {
    public int inversePairs(int [] array) {
        if (array==null||array.length==0) {
            return 0;
        }

        int []copy = new int [array.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length-1);
        return count;
    }

    int InversePairsCore(int[] data,int[] copy,int start,int end){
        if (start==end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end-start)/2;
        int left = InversePairsCore(copy,data,start,start+length);
        int right = InversePairsCore(copy,data,start+length+1,end);

        int i=start+length;
        int j=end;
        int indexCopy=end;
        int count=0;
        while (i>=start && j>=start+length+1) {
            if (data[i]>data[j]) {
                copy[indexCopy--]=data[i--];
                count +=j-start-length;
            }else{
                copy[indexCopy--]=data[j--];
            }
        }

        for(;i>=start;--i){
            copy[indexCopy--]=data[i];
        }

        for(;j>=start+length+1;--j){
            copy[indexCopy--]=data[j];
        }
        return left+right+count;
    }

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int [] array = {1,2,3,4,5,6,7,0};
        int res = inversePairs.inversePairs(array);
        System.out.println(res);
    }
}