package dataStructures;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void inOrder(BinaryTreeNode root){
        if(root != null){
            preOrder(root.getLeft());
            System.out.println(root.getData());
            preOrder(root.getRight());
        }
    }

    public void postOrder(BinaryTreeNode root){
        if(root != null){
            preOrder(root.getLeft());
            preOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public List<Integer> preOrderIterativeTraversal(BinaryTreeNode root){
        List<Integer> result = new ArrayList();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        if(root != null){
            BinaryTreeNode currentNode = root;
            stack.push(currentNode);
            while(!stack.isEmpty()){
                currentNode = stack.pop();
                result.add(currentNode.getData());
                if(currentNode.getRight() != null) stack.push(currentNode.getRight());
                if(currentNode.getLeft() != null) stack.push(currentNode.getLeft());
            }   
        }

        return result;
    }

    public List<Integer> inOrderIterativeTraversal(BinaryTreeNode root){
        List<Integer> result = new ArrayList();

        if(root != null){
            Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
            while(true){
                if(root != null){
                    stack.push(root);
                    root = root.getLeft();
                } else {
                    if(stack.isEmpty()) break;
                    else {
                        root = stack.pop();
                        result.add(root.getData());
                        root = root.getRight();
                    }
                }
            }
        }
        
        return result;
    }

    public List<Integer> postOrderIterativeTraversal(BinaryTreeNode root){
        List<Integer> result = new ArrayList();
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        if(root != null){
            stack1.push(root);
            while(!stack1.isEmpty()){
                root = stack1.pop();
                stack2.push(root);
                if(root.getLeft() != null) stack1.push(root.getLeft());
                if(root.getRight() != null) stack1.push(root.getRight());
            }
            while(!stack2.isEmpty()){
                BinaryTreeNode node = stack2.pop();
                result.add(node.getData());
            }
        }
        
        return result;
    }
}

class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public BinaryTreeNode getLeft(){
        return this.left;
    }

    public void setLeft(BinaryTreeNode node){
        this.left = node;
    }

    public BinaryTreeNode getRight(){
        return this.right;
    }

    public void setRight(BinaryTreeNode node){
        this.right = node;
    }
}