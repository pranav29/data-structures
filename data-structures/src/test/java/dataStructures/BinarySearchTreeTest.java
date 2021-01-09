package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void shouldFindAndReturnNode(){
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);

        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode result40 =  bst.find(root, 40);
        BinarySearchTreeNode result20 =  bst.find(root, 20);
        BinarySearchTreeNode result60 =  bst.find(root, 60);
        BinarySearchTreeNode result10 =  bst.find(root, 10);
        BinarySearchTreeNode result30 =  bst.find(root, 30);
        BinarySearchTreeNode result50 =  bst.find(root, 50);
        BinarySearchTreeNode result70 =  bst.find(root, 70);
        BinarySearchTreeNode result5 =  bst.find(root, 5);
        BinarySearchTreeNode result13 =  bst.find(root, 13);
        BinarySearchTreeNode result55 =  bst.find(root, 55);

        assertSame(root, result40);
        assertSame(node20, result20);
        assertSame(node60, result60);
        assertSame(node10, result10);
        assertSame(node30, result30);
        assertSame(node50, result50);
        assertSame(node70, result70);
        assertSame(node5, result5);
        assertSame(node13, result13);
        assertSame(node55, result55);
    }

    @Test
    public void shouldInsertRootNode(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);

        BinarySearchTreeNode resultRoot = bst.insert(null, 40);
        assertSame(root.getData(), resultRoot.getData());
    }

    @Test
    public void shouldInsertNode(){
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode expectedRoot = null;

        root.setLeft(node20);
        root.setRight(node60);

        expectedRoot = bst.insert(expectedRoot, 40);
        expectedRoot = bst.insert(expectedRoot, 20);
        expectedRoot = bst.insert(expectedRoot, 60);
        
        assertEquals(root.getData(), expectedRoot.getData());
        assertEquals(root.getLeft().getData(), expectedRoot.getLeft().getData());
        assertEquals(root.getRight().getData(), expectedRoot.getRight().getData());
    }

    @Test
    public void shouldFindMinimum(){
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(root, 20);
        bst.insert(root, 20);
        bst.insert(root, 60);
        bst.insert(root, 10);
        bst.insert(root, 30);
        bst.insert(root, 50);
        bst.insert(root, 70);

        BinarySearchTreeNode minimumNode = bst.findMinimum(root);
        assertSame(10, minimumNode.getData());
    }

    @Test
    public void shouldFindMaximum(){
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(root, 20);
        bst.insert(root, 20);
        bst.insert(root, 60);
        bst.insert(root, 10);
        bst.insert(root, 30);
        bst.insert(root, 50);
        bst.insert(root, 70);

        BinarySearchTreeNode maximumNode = bst.findMaximum(root);
        assertSame(70, maximumNode.getData());
    }

    @Test
    public void shouldDeleteNode(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        bst.delete(root, 13);
        bst.delete(root, 70);
        bst.delete(root, 40);

        assertNull(bst.find(root, 13));
        assertNull(bst.find(root, 70));
        assertNull(bst.find(root, 40));
    }

    @Test
    public void shouldReturnSizeOfTheTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        int expectedSize = 11;
        int actualSize = bst.size(root);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnHeightOfTheTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        int expectedHeight = 4;
        int actualHeight = bst.height(root);
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    public void shouldReturnTrueForSameTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        boolean result = bst.isSame(root, root);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseForDifferentTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root1 = new BinarySearchTreeNode(40);
        BinarySearchTreeNode root1node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode root1node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode root1node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode root1node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode root1node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode root1node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode root1node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode root1node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode root1node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode root1node80 = new BinarySearchTreeNode(80);
        
        root1.setLeft(root1node20);
        root1.setRight(root1node60);
        root1node20.setLeft(root1node10);
        root1node20.setRight(root1node30);
        root1node10.setLeft(root1node5);
        root1node10.setRight(root1node13);
        root1node60.setLeft(root1node50);
        root1node60.setRight(root1node70);
        root1node50.setRight(root1node55);
        root1node70.setRight(root1node80);

        BinarySearchTreeNode root2 = new BinarySearchTreeNode(40);
        BinarySearchTreeNode root2node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode root2node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode root2node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode root2node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode root2node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode root2node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode root2node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode root2node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode root2node55 = new BinarySearchTreeNode(55);
        
        root2.setLeft(root2node20);
        root2.setRight(root2node60);
        root2node20.setLeft(root2node10);
        root2node20.setRight(root2node30);
        root2node10.setLeft(root2node5);
        root2node10.setRight(root2node13);
        root2node60.setLeft(root2node50);
        root2node60.setRight(root2node70);
        root2node50.setRight(root2node55);

        boolean result = bst.isSame(root1, root2);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueForSameTreeUsingNonRecoursiveComapre(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        boolean result = bst.nonRecursiveIsSame(root, root);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseForDifferentTreeUsingNonRecursiveCompare(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root1 = new BinarySearchTreeNode(40);
        BinarySearchTreeNode root1node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode root1node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode root1node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode root1node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode root1node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode root1node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode root1node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode root1node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode root1node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode root1node80 = new BinarySearchTreeNode(80);
        
        root1.setLeft(root1node20);
        root1.setRight(root1node60);
        root1node20.setLeft(root1node10);
        root1node20.setRight(root1node30);
        root1node10.setLeft(root1node5);
        root1node10.setRight(root1node13);
        root1node60.setLeft(root1node50);
        root1node60.setRight(root1node70);
        root1node50.setRight(root1node55);
        root1node70.setRight(root1node80);

        BinarySearchTreeNode root2 = new BinarySearchTreeNode(40);
        BinarySearchTreeNode root2node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode root2node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode root2node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode root2node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode root2node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode root2node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode root2node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode root2node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode root2node55 = new BinarySearchTreeNode(55);
        
        root2.setLeft(root2node20);
        root2.setRight(root2node60);
        root2node20.setLeft(root2node10);
        root2node20.setRight(root2node30);
        root2node10.setLeft(root2node5);
        root2node10.setRight(root2node13);
        root2node60.setLeft(root2node50);
        root2node60.setRight(root2node70);
        root2node50.setRight(root2node55);

        boolean result = bst.nonRecursiveIsSame(root1, root2);
        assertFalse(result);
    }

    @Test
    public void shouldReturnRootToLeafSequenceForSum(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        int sum = 83;
        List<Integer> actualResult = new ArrayList<Integer>();
        List<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(40);
        expectedResult.add(20);
        expectedResult.add(10);
        expectedResult.add(13);

        boolean isSequencePresentForSum = bst.rootToLeafSum(root, sum, actualResult);
        Collections.reverse(actualResult);

        assertTrue(isSequencePresentForSum);
        assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void shouldReturnTrueIfBinarySearchTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTreeNode root = new BinaryTreeNode(40);
        BinaryTreeNode node20 = new BinaryTreeNode(20);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node30 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node60 = new BinaryTreeNode(60);
        BinaryTreeNode node50 = new BinaryTreeNode(50);
        BinaryTreeNode node70 = new BinaryTreeNode(70);
        BinaryTreeNode node55 = new BinaryTreeNode(55);
        BinaryTreeNode node80 = new BinaryTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        boolean result = bst.isBinarySearchTree(root, 0, 100);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNotBinarySearchTree(){
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTreeNode root = new BinaryTreeNode(40);
        BinaryTreeNode node20 = new BinaryTreeNode(20);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node30 = new BinaryTreeNode(30);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node43 = new BinaryTreeNode(43);
        BinaryTreeNode node60 = new BinaryTreeNode(60);
        BinaryTreeNode node50 = new BinaryTreeNode(50);
        BinaryTreeNode node70 = new BinaryTreeNode(70);
        BinaryTreeNode node55 = new BinaryTreeNode(55);
        BinaryTreeNode node80 = new BinaryTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node43);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        boolean result = bst.isBinarySearchTree(root, 0, 100);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTreeInSpiralOrder(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        List<Integer> actualResult = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(40);
        expectedResult.add(60);
        expectedResult.add(20);
        expectedResult.add(10);
        expectedResult.add(30);
        expectedResult.add(50);
        expectedResult.add(70);
        expectedResult.add(80);
        expectedResult.add(55);
        expectedResult.add(13);
        expectedResult.add(5);

        actualResult = bst.levelOrderTraversalInSpiralOrder(root);
        assertTrue(expectedResult.equals(actualResult));
    }

    @Test
    public void shouldReturnInOrderTraversalUsingMorris(){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTreeNode root = new BinarySearchTreeNode(40);
        BinarySearchTreeNode node20 = new BinarySearchTreeNode(20);
        BinarySearchTreeNode node10 = new BinarySearchTreeNode(10);
        BinarySearchTreeNode node30 = new BinarySearchTreeNode(30);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node13 = new BinarySearchTreeNode(13);
        BinarySearchTreeNode node60 = new BinarySearchTreeNode(60);
        BinarySearchTreeNode node50 = new BinarySearchTreeNode(50);
        BinarySearchTreeNode node70 = new BinarySearchTreeNode(70);
        BinarySearchTreeNode node55 = new BinarySearchTreeNode(55);
        BinarySearchTreeNode node80 = new BinarySearchTreeNode(80);
        
        root.setLeft(node20);
        root.setRight(node60);
        node20.setLeft(node10);
        node20.setRight(node30);
        node10.setLeft(node5);
        node10.setRight(node13);
        node60.setLeft(node50);
        node60.setRight(node70);
        node50.setRight(node55);
        node70.setRight(node80);

        List<Integer> actualResult = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(5);
        expectedResult.add(10);
        expectedResult.add(13);
        expectedResult.add(20);
        expectedResult.add(30);
        expectedResult.add(40);
        expectedResult.add(50);
        expectedResult.add(55);
        expectedResult.add(60);
        expectedResult.add(70);
        expectedResult.add(80);

        actualResult = bst.morrisInorderTraversal(root);
        assertTrue(expectedResult.equals(actualResult));
    }
}
