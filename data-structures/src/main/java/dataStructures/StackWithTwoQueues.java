package dataStructures;

public class StackWithTwoQueues {
    Queue queue1 = new Queue();
    Queue queue2 = new Queue();

    public void push(int value){
        if(!queue2.isEmpty()){
            queue2.enqueue(value);
        } else {
            queue1.enqueue(value);
        }
    }

    public int pop(){
        int data;

        if(!queue1.isEmpty()){
            for(int i = 0; i < queue1.length()-1; i++){
                queue2.enqueue(queue1.dequeue());
            }
            data = queue1.dequeue();
        } else {
            for(int i = 0; i < queue2.length()-1; i++){
                queue1.enqueue(queue2.dequeue());
            }
            data = queue1.dequeue();
        }
        

        return data;
    }
}
