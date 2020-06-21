package niuke;

import java.util.ArrayList;

public class reOrderArray {
    public void ReOrderArray(int [] array) {
        if (array==null) { return;}
        if(array.length<=1){return;}

        ArrayList<Integer> odd = new  ArrayList<>();
        ArrayList<Integer> even = new  ArrayList<>();

        for (Integer integer : array) {
            if(integer%2==0){
                even.add(integer);
            }else{
                odd.add(integer);
            }
        }

        int i = 0;
        for (Integer integer : odd) {
            array[i++] = integer;
        }

        for (Integer integer : even) {
            array[i++] = integer;
        }
    }

    public static void main(String[] args) {
        int []array={1,2,3,4,5,6,7};
        reOrderArray reOrderArray = new reOrderArray();
        reOrderArray.ReOrderArray(array);
    }
}