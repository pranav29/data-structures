package dataStructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
    
    @Test
    public void shouldEnqueueIfNotFull(){
        Queue queue = new Queue(1);
        queue.enqueue(1);
        int length = queue.length();
        assertSame(1, length);
    }

    @Test
    public void shouldNotEnqueueIfFull(){
        try {
            Queue queue = new Queue(1);
            queue.enqueue(1);
            queue.enqueue(2);
        } catch(IllegalStateException e){
            assertSame("Queue is full", e.getMessage());
        }
    }

    @Test
    public void shouldDequeueIfNotEmpty(){
        Queue queue = new Queue(2);
        int value1 = 1;
        int value2 = 2;
        queue.enqueue(value1);
        queue.enqueue(value2);
        int result = queue.dequeue();
        assertSame(value1, result);
    }

    @Test
    public void shouldNotDequeueIfEmpty(){
        try {
            Queue queue = new Queue(2);
            queue.dequeue();
        } catch(IllegalStateException e){
            assertSame("Queue is empty", e.getMessage());
        }
    }

    @Test
    public void shouldPeekFront(){
        Queue queue = new Queue(2);
        int value1 = 1;
        int value2 = 2;
        queue.enqueue(value1);
        queue.enqueue(value2);
        int result = queue.peek();
        assertSame(value1, result);
    }

    @Test
    public void shouldBeTrueIfFull(){
        Queue queue = new Queue(2);
        int value1 = 1;
        int value2 = 2;
        queue.enqueue(value1);
        queue.enqueue(value2);
        boolean result = queue.isFull();
        assertTrue(result);
    }
    
    @Test
    public void shouldBeFalseIfNotFull(){
        Queue queue = new Queue(2);
        int value = 1;
        queue.enqueue(value);
        boolean result = queue.isFull();
        assertFalse(result);
    }

    @Test
    public void shouldBeTrueIfEmpty(){
        Queue queue = new Queue(2);
        int value1 = 1;
        int value2 = 2;
        queue.enqueue(value1);
        queue.enqueue(value2);
        queue.dequeue();
        queue.dequeue();
        boolean result = queue.isEmpty();
        assertTrue(result);        
    }

    @Test
    public void shouldBeFalseIfNotEmpty(){
        Queue queue = new Queue(2);
        int value = 1;
        queue.enqueue(value);
        boolean result = queue.isEmpty();
        assertFalse(result);        
    }
}
