package niuke;

public class MinNumberInRotateArray {

    int []array;
    //找到未旋转前的第一个数就是最小的
    public int minNumberInRotateArray(int [] array) {
        if(array==null){return 0;}
        if(array.length==0){return 0;}
        this.array = array;
        return bfs(0,array.length-1);
    }

    public int bfs(int left,int right){
        if (left==right) {
            return array[left];
        }
        int mid = (left+right)/2;
        //说明没有进行旋转
        if(array[left]<=array[mid]&&array[mid+1]<=array[right]){
            return Math.min(array[left],array[mid+1]);
        }

        //说明左半边是有序的，旋转部分在右半边
        if (array[left]<=array[mid]) {
            return bfs(mid+1,right);
        }else if(array[mid+1]<=array[right]){
            return bfs(left,mid);
        }

        return -1;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
        int []array = new int[]{3,4,5,1,2};
        int res=minNumberInRotateArray.minNumberInRotateArray(array);
        System.out.println(res);
    }
}