package dataStructures;

public class Stack {
    private int size;
    private int top;
    private int[] stackArray;

    public Stack() {
        size = 50;
        top = -1;
        stackArray = new int[size];
    }

    public Stack(int size){
        this.size = size;
        top = -1;
        stackArray = new int[size];
    }

    public boolean push(int value){
        boolean status = false;
        if(isFull())
            throw new IllegalStateException("Stack is full");
            
        stackArray[++top] = value;
        status = true;
        return status;
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");

        return stackArray[top--];
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");
            
        return stackArray[top];
    }
    
    public boolean isFull(){
        return length() == size;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int length(){
        return top+1;
    }
}
