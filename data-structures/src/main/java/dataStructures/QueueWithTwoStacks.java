package dataStructures;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void enqueue(T data){
        stack1.push(data);
    }

    public T dequeue(){
        T data;
        if(stack2.empty()){
           while(!stack1.empty()){
               stack2.push(stack1.pop());
           }
        }
        data = stack2.pop();

        return data;
    }
}
