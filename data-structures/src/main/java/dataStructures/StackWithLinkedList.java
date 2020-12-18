package dataStructures;

public class StackWithLinkedList {
    private int length;
    private ListNode top;

    public StackWithLinkedList(){
        length = 0;
        top = null;
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        node.setNext(top);
        top.setNext(node);
        length++;
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");

        ListNode result = top;
        top.setNext(top.getNext());
        result.setNext(null);
        length--;
        return result.getData();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException("Stack is empty");

        return top.getData();
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
}