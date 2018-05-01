package LeetCode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {

        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
       if(min==stack.pop()){
           min = stack.pop();
       }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);

        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());


    }
}
