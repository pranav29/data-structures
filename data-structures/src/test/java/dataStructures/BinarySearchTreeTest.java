package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

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
}
