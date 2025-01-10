package ProblemSolving.Heaps;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args){
        System.out.println(kthLargest(List.of(3,2,1,5,6,4), 2));
        System.out.println(kthLargest(List.of(34,67,2,89,23,45),3));
    }
    public static int kthLargest(List<Integer> arr, int k){
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i=0;i<arr.size();i++)
//            set.add(arr.get(i));
//        while(k>1){
//            set.pollLast();
//            k--;
//        }
//        return set.pollLast();
        // using minheap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<arr.size();i++) {
            minHeap.add(arr.get(i));
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
