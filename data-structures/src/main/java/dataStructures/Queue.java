package dataStructures;

public class Queue {
    private int front = 0;
    private int rear = -1;
    private int size;
    private int[] queue;

    public Queue(){
        size = 50;
        queue = new int[size];
    }

    public Queue(int size){
        this.size = size;
        queue = new int[this.size];
    }

    public void enqueue(int value){
        if(isFull())
            throw new IllegalStateException("Queue is full");

        queue[++rear] = value;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");

        int[] tempQueue = new int[size];
        int result = queue[front];
        for(int i = front; i < rear; i++){
            tempQueue[i] = queue[i+1];
        }
        queue = tempQueue;
        rear -= 1;
        return result;
    }

    public int peek(){
        return queue[front];
    }

    public boolean isFull(){
        return rear == queue.length - 1;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public int length(){
        return rear - front + 1;
    }
}
