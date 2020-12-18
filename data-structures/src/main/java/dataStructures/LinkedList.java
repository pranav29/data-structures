package dataStructures;

public class LinkedList {
    private ListNode head;
    private int length;

    public LinkedList(){
        this.length = 0;
    }

    public void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(ListNode node){
        if(head == null){
            head = node;
        } else {
            ListNode tempNode = head;
            for(int i = 1; i < length; i++){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(node);
        }
        length++;
    }

    public void insertAtPosition(ListNode node, int position){

        if(position < 0){
            position = 0;
        }
        if(position > length){
            position = length;
        }
        if(head == null){
            head = node;
        } else if(position == 0){
            ListNode temp = head.getNext();
            head = node;
            node.setNext(temp);
        } else {
            ListNode current = head;
            for(int i = 1; i < position; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);  
        }  
        length++; 
    }

    public ListNode deleteAtStart(){
        ListNode result = null;
        if(head != null){
            result = head;
            head = head.getNext();
            result.setNext(null);
            length--;
        }
        return result;
    }

    public ListNode deleteAtEnd(){
        ListNode result = null;
        if(head == null)
            return result;

        ListNode temp = head;
        ListNode previous = head;
        for(int i = 1; i < length; i++){
            previous = temp;
            temp = temp.getNext();
        }
        result = temp;
        previous.setNext(null);
        length--;
        return result;
    }

    public ListNode deleteAtPosition(int position){
        ListNode result = null;
        if(position < 0)
            position = 0;
        
        if(position > length)
            position = length;
        
        if(head == null)
            return result;
        
        if(position == 0){
            ListNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            result = temp;
        } else {
            ListNode previous = head;
            ListNode current = head.getNext();
            for(int i = 1; i < length; i++){
                if(i == position){
                    previous.setNext(current.getNext());
                    current.setNext(null);
                    result = current;
                    break;
                }
                previous = current;
                current = current.getNext();
            }
        }
        return result;
    }

    public int length(){
        return length;
    }

    public int getPosition(int data){
        int position = -1;
        ListNode temp = head;

        for(int i = 0; i < length; i++){
            if(temp.getData() == data){
                position = i;
                break;
            }
            temp = temp.getNext();
        }

        return position;
    }

    public void clearList(){
        head = null;
        length = 0;
    }
}

class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int value){
        this.data = value;
    }

    public void setNext(ListNode node){
        this.next = node;
    }

    public ListNode getNext(){
        return this.next;
    }
}
