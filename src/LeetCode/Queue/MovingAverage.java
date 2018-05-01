package LeetCode.Queue;

import java.util.ArrayDeque;


public class MovingAverage {

    ArrayDeque<Integer> movingQueue = new ArrayDeque<>(this.size);

    private int size;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        addElement(val);
        double noOfElements = movingQueue.size();
        return caculateVal(movingQueue)/noOfElements;
    }

    private void addElement(int val) {
        if (movingQueue.size() == this.size) {
            movingQueue.pop();
        }
        movingQueue.add(val);
    }

    private int caculateVal(ArrayDeque<Integer> val) {
        int sum=0;
        for(int i=0; i<movingQueue.size(); i++){
            int temp = val.pop();
            sum = sum+temp;
            movingQueue.add(temp);
         }
         return sum;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
            m.next(1);
        System.out.println(m.next(10));
            m.next(3);
        System.out.println(m.next(5));
    }
}
