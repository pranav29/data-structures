package dataStructures;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class CircularLinkedListTest {
    
    @Test
    public void shouldInsertNodeAtTheBegin(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtBegin(node1);
        list.insertAtBegin(node2);
        int position = list.getPosition(node2.getData());
        int length = list.length();
        assertSame(0, position);
        assertSame(2, length);
    }

    @Test
    public void shouldInsertNodeAtTheEnd(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        int position = list.getPosition(node2.getData());
        int length = list.length();
        assertSame(1, position);
        assertSame(2, length);
    }

    @Test
    public void shouldInsertNodeAtThePosition(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularListNode node3 = new CircularListNode(3);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtPosition(node1, 0);
        list.insertAtPosition(node2, 1);
        list.insertAtPosition(node3, 1);
        int positionNode1 = list.getPosition(node1.getData());
        int positionNode2 = list.getPosition(node2.getData());
        int positionNode3 = list.getPosition(node3.getData());
        int length = list.length();
        assertSame(0, positionNode1);
        assertSame(2, positionNode2);
        assertSame(1, positionNode3);
        assertSame(3, length);
    }

    @Test
    public void shouldDeleteNodeAtTheBegin(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtBegin(node1);
        list.insertAtBegin(node2);
        CircularListNode result = list.deleteAtBegin();
        int length = list.length();
        assertSame(node2, result);
        assertSame(1, length);
    }

    @Test
    public void shouldDeleteNodeAtTheEnd(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        CircularListNode result = list.deleteAtEnd();
        int length = list.length();
        assertSame(node2, result);
        assertSame(1, length);
    }

    @Test
    public void shouldDeleteNodeAtThePosition(){
        CircularListNode node1 = new CircularListNode(1);
        CircularListNode node2 = new CircularListNode(2);
        CircularListNode node3 = new CircularListNode(3);
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtPosition(node1, 0);
        list.insertAtPosition(node2, 1);
        list.insertAtPosition(node3, 1);
        CircularListNode result = list.deleteAtPosition(1);
        int length = list.length();
        assertSame(node3, result);
        assertSame(2, length);
    }
}
