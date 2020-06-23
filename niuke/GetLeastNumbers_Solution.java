package niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    //这方法超时
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (input!=null && input.length>k) {
            int low = 0;
            int high = input.length-1;
            int pivotpos = Partition(input, low, high);
            while (pivotpos!=k-1) {
               if (pivotpos>k-1) {
                    high = pivotpos-1;
               }else{
                    low = pivotpos+1;
               }
               pivotpos=Partition(input, low, high);
            }
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        }
      
        return res;

    }

    private int Partition(int[] Vector,int low,int high){

        int pivotpos = low;
        int pivot = Vector[low];
        
        for (int i = low; i <=high; i++) {
            if (Vector[i]<pivot) {
                pivotpos++;
                if (pivotpos!=i) {
                    swap(Vector, i, pivotpos);
                }

            }
        }
        swap(Vector,low, pivotpos);
        
        return pivotpos;
    }

    private void swap(int[] Vector,int i,int j){
        int temp = Vector[i];
        Vector[i] = Vector[j];
        Vector[j] = temp; 
    }

    public static void main(String[] args) {
        int[]input = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution g = new GetLeastNumbers_Solution();
        ArrayList<Integer> res = g.getLeastNumbers_Solution(input,4);
        for (Integer integer : res) {
            System.out.println(integer);   
        }
    }

    //方法2
    public ArrayList<Integer> getLeastNumbers_Solution2(int[] input, int k){    
         ArrayList<Integer> result = new ArrayList<Integer>();
               int length = input.length;
               if(k > length || k == 0){
                   return result;
               }
                
               PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
                for (int i = 0; i < length; i++) {
                    if (maxHeap.size() != k) {
                        maxHeap.offer(input[i]);
                    } else if (maxHeap.peek() > input[i]) {
                        Integer temp = maxHeap.poll();
                        temp = null;
                        maxHeap.offer(input[i]);
                    }
                }
                for (Integer integer : maxHeap) {
                    result.add(integer);
                }
                return result;
    }

}