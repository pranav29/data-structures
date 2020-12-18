package dataStructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTest {

    @Test
    public void pushShouldAddValueToStack(){
        Stack stack = new Stack();
        int value = 50;
        boolean result = stack.push(value);
        assertTrue(result);
    }

    @Test
    public void pushShouldNotaddValueIfStackIsFull(){
        Stack stack = new Stack(1);
        int firstValue = 50;
        int secondValue = 50;
        stack.push(firstValue);
        boolean result = stack.push(secondValue);
        assertFalse(result);
        assertSame(stack.length(), 1);
    }

    @Test
    public void popShouldReturnValueFromTopOfStack(){
        Stack stack = new Stack();
        int value = 50;
        stack.push(value);
        int result = stack.pop();
        assertSame(result, value);
    }

    @Test
    public void isFullShouldReturnTrue(){
        Stack stack = new Stack(1);
        stack.push(50);
        boolean result = stack.isFull();
        assertTrue(result);
    }

    @Test
    public void isFullShouldReturnFalseIfStackIsNotFull(){
        Stack stack = new Stack(1);
        boolean result = stack.isFull();
        assertFalse(result);
    }

    @Test
    public void isEmptyShouldReturnTrue(){
        Stack stack = new Stack();
        boolean result = stack.isEmpty();
        assertTrue(result);
    }

    @Test
    public void isEmptyShouldReturnFalseIfStackIsNotEmpty(){
        Stack stack = new Stack();
        boolean result = stack.isEmpty();
        assertTrue(result);
    }
}