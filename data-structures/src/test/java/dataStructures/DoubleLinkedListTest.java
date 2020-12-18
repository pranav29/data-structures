package dataStructures;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class DoubleLinkedListTest {
    
    @Test
    public void shouldReturnCorrectPositionOfNode(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        list.insertAtEnd(node3);
        int position1 = list.getPosition(node1.getData());
        int position2 = list.getPosition(node2.getData());
        int position3 = list.getPosition(node3.getData());

        assertSame(0, position1);
        assertSame(1, position2);
        assertSame(2, position3);
    }

    @Test
    public void shouldInsertNodeAtTheBegin(){
        DoubleListNode node = new DoubleListNode(1);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtBegin(node);
        int position = list.getPosition(node.getData());
        int length = list.length();
        assertSame(0, position);
        assertSame(1, length);
    }

    @Test
    public void shouldAddNodeAtTheEnd(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        int position = list.getPosition(node2.getData());
        int length = list.length();
        assertSame(1, position);
        assertSame(2, length);
    }

    @Test
    public void shouldInsertNodeAtThePosition(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtPosition(node1, 0);
        list.insertAtPosition(node2, 1);
        list.insertAtPosition(node3, 1);
        int position = list.getPosition(node3.getData());
        assertSame(1, position);
    }

    @Test
    public void shouldDeleteNodeAtTheBegin(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtBegin(node1);
        list.insertAtBegin(node2);
        DoubleListNode result = list.deleteAtBegin();
        int length = list.length();
        assertSame(node2, result);
        assertSame(1, length);
    }

    @Test
    public void shouldDeleteNodeAtTheEnd(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        DoubleListNode result = list.deleteAtEnd();
        int length = list.length();
        assertSame(node2, result);
        assertSame(1, length);
    }

    @Test
    public void shouldDeleteNodeAtThePosition(){
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        list.insertAtEnd(node3);
        DoubleListNode result = list.deleteAtPosition(1);
        int length = list.length();
        assertSame(node2, result);
        assertSame(2, length);
    }
}
