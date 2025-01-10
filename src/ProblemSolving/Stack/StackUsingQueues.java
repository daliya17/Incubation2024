package ProblemSolving.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
   private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x){
        queue1.add(x);
    }

    public int pop(){
        if(queue1.isEmpty()){
            return -1;
        }
        while (queue1.size() >1){
            queue2.add(queue1.poll());
        }
        int temp = queue1.poll();
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;
        return temp;
    }
}
