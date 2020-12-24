package dataStructures;

public class BinarySearchTree {

    public BinarySearchTreeNode find(BinarySearchTreeNode root, int data){
        if(root == null) return null;
        if(root.getData() == data) return root;
        if(root.getData() < data) return find(root.getRight(), data);
        else return find(root.getLeft(), data);
    }

    public BinarySearchTreeNode nonRecursiveFind(BinarySearchTreeNode root, int data){
        if(root == null) return null;
        while(root != null){
            if(root.getData() == data) break;
            if(root.getData() < data) root = root.getRight();
            else root = root.getLeft(); 
        }
        return root;
    }

    public BinarySearchTreeNode findMinimum(BinarySearchTreeNode root){
        if(root == null) return null;
        if(root.getLeft() == null) return root;
        else return findMinimum(root.getLeft());
    }

    public BinarySearchTreeNode nonRecursiveFindMinimum(BinarySearchTreeNode root){
        if(root == null) return null;
        while(root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }
    
    public BinarySearchTreeNode findMaximum(BinarySearchTreeNode root){
        if(root == null) return null;
        if(root.getRight() == null) return root;
        else return findMaximum(root.getRight());
    }

    public BinarySearchTreeNode nonRecursiveFindMaximum(BinarySearchTreeNode root){
        if(root == null) return null;
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    public BinarySearchTreeNode insert(BinarySearchTreeNode root, int data){
        if(root == null) {
            root = new BinarySearchTreeNode(data);
        } else {
            if(data < root.getData()) root.setLeft(insert(root.getLeft(), data));
            else root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    public BinarySearchTreeNode nonRecursiveInsert(BinarySearchTreeNode root, int data){
        BinarySearchTreeNode node = new BinarySearchTreeNode(data);
        if(root == null) return node;
        
        BinarySearchTreeNode parent = null;
        BinarySearchTreeNode current = root;
        while(current != null){
            parent = current;
            if(current.getData() < data) current = current.getRight();
            else current = current.getLeft();
        }
        if(parent.getData() < data) parent.setRight(node);
        else parent.setLeft(node);
        return root;
    }
}

class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public BinarySearchTreeNode getLeft(){
        return this.left;
    }

    public void setLeft(BinarySearchTreeNode node){
        this.left = node;
    }
    
    public BinarySearchTreeNode getRight(){
        return this.right;
    }

    public void setRight(BinarySearchTreeNode node){
        this.right = node;
    }
}
