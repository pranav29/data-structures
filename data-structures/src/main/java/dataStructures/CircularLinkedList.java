package dataStructures;

public class CircularLinkedList {
   private int length;
   private CircularListNode tail;
   
   public CircularLinkedList(){
       length = 0;
   }

   public void insertAtBegin(CircularListNode node){
       if(tail == null){
           tail = node;
           tail.setNext(tail);
       } else {
           CircularListNode current = tail;
           while(current.getNext() != tail){
               current = current.getNext();
           }
           current.setNext(node);
           node.setNext(tail);
           tail = node;
       }
       length++;
   }

   public void insertAtEnd(CircularListNode node){
        if(tail == null){
            tail = node;
            tail.setNext(tail);
        } else {
            CircularListNode current = tail;
            while(current.getNext() != tail){
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(tail);
        }
        length++;   
   }

   public void insertAtPosition(CircularListNode node, int position){
        if(position < 0)
            position = 0;
        
        if(position > length)
            position = length;
        
        if(position == 0)
            insertAtBegin(node);
        else {
            CircularListNode current = tail;
            for(int i = 1; i < position; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            length++;
        }
   }

   public CircularListNode deleteAtBegin(){
       CircularListNode result = null;
       if(tail != null){
           result = tail;
           CircularListNode temp = tail;
           for(int i = 1; i < length; i++){
                temp = temp.getNext();
           }
           tail = tail.getNext();
           temp.setNext(tail);
           result.setNext(null);
           length--;
       }
       return result;
   }

   public CircularListNode deleteAtEnd(){
       CircularListNode result = null;
       if(tail != null){
           CircularListNode temp = tail;
           for(int i = 1; i < length-1; i++){
                if(temp.getNext().getNext() != tail) temp = temp.getNext();
           }
           result = temp.getNext();
           temp.setNext(tail);
           result.setNext(null);
           length--;
       }
       return result;
   }

   public CircularListNode deleteAtPosition(int position){
        CircularListNode result = null;
        if(position < 0)
            position = 0;
        
        if(position > length-1)
            position = length;
        
        if(position == 0)
            result = deleteAtBegin();
        else {
            CircularListNode temp = tail;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            result = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            result.setNext(null);
            length--;
        }
        return result;
   }

   public int length(){
       return length;
   }

   public int getPosition(int data){
       int position = -1;
       if(tail != null){
           CircularListNode temp = tail;
           for(int i =0; i < length; i++){
                if(temp.getData() == data){
                    position = i;
                    break;
                }
                temp = temp.getNext();
           }
       }
       return position;
   }
}

class CircularListNode {
    private int data;
    private CircularListNode next;

    public CircularListNode(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public CircularListNode getNext(){
        return this.next;
    }

    public void setData(int data){
        this.data = data;
    }

    public void setNext(CircularListNode node){
        this.next = node;
    }
}
