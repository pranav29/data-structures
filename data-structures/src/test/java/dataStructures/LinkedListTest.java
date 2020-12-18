package dataStructures;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void shouldReturnCorrectPositionOfNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        LinkedList list = new LinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        list.insertAtEnd(node3);
        int result1 = list.getPosition(node1.getData());
        int result2 = list.getPosition(node2.getData());
        int result3 = list.getPosition(node3.getData());
        assertSame(0, result1);
        assertSame(1, result2);
        assertSame(2, result3);
    }
   
    @Test 
    public void shouldAddNodeAtTheStart(){
        ListNode node1 = new ListNode(1);
        LinkedList list = new LinkedList();
        list.insertAtBegin(node1);
        int result = list.length();
        int position = list.getPosition(node1.getData());
        assertSame(1, result);
        assertSame(0, position);
    }

    @Test
    public void shouldAddNodeAtTheEnd(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        LinkedList list = new LinkedList();
        list.insertAtBegin(node1);
        list.insertAtEnd(node2);
        int result = list.length();
        int position = list.getPosition(node2.getData());
        assertSame(2, result);
        assertSame(1, position);
    }

    @Test
    public void shouldAddNodeAtThePositionProvided(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        LinkedList list = new LinkedList();
        list.insertAtPosition(node1, 0);
        list.insertAtPosition(node2, 1);
        list.insertAtPosition(node3, 1);
        int position = list.getPosition(node3.getData());
        assertSame(1, position);
    }

    @Test
    public void shouldDeleteNodeAtTheStart(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        LinkedList list = new LinkedList();
        list.insertAtBegin(node1);
        list.insertAtBegin(node2);
        ListNode result = list.deleteAtStart();
        assertSame(node2, result);
    }

    @Test
    public void shouldDeleteNodeAtTheEnd(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        LinkedList list = new LinkedList();
        list.insertAtBegin(node1);
        list.insertAtEnd(node2);
        ListNode result = list.deleteAtEnd();
        assertSame(node2, result);
    }

    @Test
    public void shouldDeleteNodeAtThePosition(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        LinkedList list = new LinkedList();
        list.insertAtEnd(node1);
        list.insertAtEnd(node2);
        list.insertAtEnd(node3);
        ListNode result = list.deleteAtPosition(1);
        assertSame(node2, result);
    }
}
