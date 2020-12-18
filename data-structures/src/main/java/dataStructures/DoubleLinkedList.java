package dataStructures;

public class DoubleLinkedList {
    private DoubleListNode head;
    private int length;

    public DoubleLinkedList() {
        length = 0;
    }

    public void insertAtBegin(DoubleListNode node) {
        if (head != null) {
            node.setNext(head);
            head.setPrevious(node);
        }
        head = node;
        length++;
    }

    public void insertAtEnd(DoubleListNode node) {
        if (head == null) {
            head = node;
        } else {
            DoubleListNode current = head;
            while (current.getNext() != null)
                current = current.getNext();

            node.setPrevious(current);
            current.setNext(node);
        }
        length++;
    }

    public void insertAtPosition(DoubleListNode node, int position) {
        if (position < 0)
            position = 0;

        if (position > length)
            position = length;

        if (head == null)
            head = node;
        else if (position == 0) {
            insertAtBegin(node);
        } else {
            DoubleListNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrevious(current);
            if(node.getNext() != null) node.getNext().setPrevious(node);
            current.setNext(node);
        }
        length++;
    }

    public DoubleListNode deleteAtBegin() {
        DoubleListNode node = null;

        if (head != null) {
            node = head;
            head = head.getNext();
            head.setPrevious(null);
            node.setNext(null);
            length--;
        }

        return node;
    }

    public DoubleListNode deleteAtEnd() {
        DoubleListNode nodeToRemove = null;

        if (head != null) {
            DoubleListNode current = head;
            while (current.getNext() != null)
                current = current.getNext();

            nodeToRemove = current;
            DoubleListNode newLastNode = current.getPrevious();
            nodeToRemove.setPrevious(null);
            newLastNode.setNext(null);
            length--;
        }

        return nodeToRemove;
    }

    public DoubleListNode deleteAtPosition(int position) {
        DoubleListNode nodeToRemove = null;

        if (head != null) {
            DoubleListNode current = head;
            int i = 0;
            while (i != position) {
                current = current.getNext();
                i++;
            }
            nodeToRemove = current;
            DoubleListNode previous = current.getPrevious();
            DoubleListNode next = current.getNext();
            previous.setNext(next);
            next.setPrevious(previous);
            nodeToRemove.setPrevious(null);
            nodeToRemove.setNext(null);
            length--;
        }

        return nodeToRemove;
    }

    public int length() {
        return length;
    }

    public int getPosition(int data) {
        int position = -1;
        if (head != null) {
            DoubleListNode current = head;
            for (int i = 0; i < length; i++) {
                if (current.getData() == data) {
                    position = i;
                    break;
                }
                current = current.getNext();
            }
        }

        return position;
    }
}

class DoubleListNode {
    private int data;
    private DoubleListNode previous;
    private DoubleListNode next;

    public DoubleListNode(int data) {
        this.data = data;
    }

    public DoubleListNode(int data, DoubleListNode previous, DoubleListNode next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public DoubleListNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(DoubleListNode node) {
        this.previous = node;
    }

    public DoubleListNode getNext() {
        return this.next;
    }

    public void setNext(DoubleListNode node) {
        this.next = node;
    }
}