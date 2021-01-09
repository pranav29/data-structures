package dataStructures;

public class AVLTree {
    
    public BinarySearchTreeNode insert(BinarySearchTreeNode root, int data){
        if(root == null) return new BinarySearchTreeNode(data);
        if(root.getData() > data){
            root.setLeft(insert(root.getLeft(), data));
        } else {
            root.setRight(insert(root.getRight(), data));
        }

        int balance = height(root.getLeft()) - height(root.getRight());
        if(balance > 1){
            if(height(root.getLeft().getLeft()) >= height(root.getLeft().getRight())){
                root = rotateRight(root); 
            } else {
                root.setLeft(rotateLeft(root.getLeft()));
                root = rotateRight(root);
            }
        } else if(balance < -1){
            if(height(root.getRight().getRight()) >= height(root.getRight().getLeft())){
                root = rotateLeft(root);
            } else {
                root.setRight(rotateRight(root.getRight()));
                root = rotateLeft(root);
            }
        }

        return root;
    }

    private int height(BinarySearchTreeNode root){
        int height = 0;
        if(root != null){
            int leftHeight = height(root.getLeft());
            int rightHeight = height(root.getRight());
            height = 1 + Math.max(leftHeight, rightHeight);
        }
        return height;
    }

    private BinarySearchTreeNode rotateRight(BinarySearchTreeNode root){
        BinarySearchTreeNode newRoot = root.getLeft();
        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);
        return newRoot;
    }

    private BinarySearchTreeNode rotateLeft(BinarySearchTreeNode root){
        BinarySearchTreeNode newRoot = root.getRight();
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);
        return newRoot;
    }
}
