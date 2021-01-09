package dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;
import java.util.Queue;

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

    public BinarySearchTreeNode delete(BinarySearchTreeNode root, int data){
        if(root == null) return null;
        if(data < root.getData()) {
             root.setLeft(delete(root.getLeft(), data)); 
        } else if(data > root.getData()){
            root.setRight(delete(root.getRight(), data));
        } else {
            // Case 1: both chile nodes present
            if(root.getLeft() != null && root.getRight() != null){
                BinarySearchTreeNode minimum = findMinimum(root.getRight());
                root.setData(minimum.getData());
                root.setRight(delete(root.getRight(), minimum.getData()));
            } // Case 2: one child 
            else if(root.getLeft() != null){
                root = root.getLeft();
            } else if(root.getRight() != null){
                root = root.getRight();
            } // Case 3: leaf node 
            else {
                root = null;
            }
        }
        return root;
    }

    public int size(BinarySearchTreeNode root){
        if(root == null) return 0;
        int size = 1 + size(root.getLeft()) + size(root.getRight());
        return size;
    }

    public int nonRecursivesize(BinarySearchTreeNode root){
        if(root == null) return 0;

        Stack<BinarySearchTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BinarySearchTreeNode currentNode = root;
        stack.push(currentNode);
        while(!stack.isEmpty()){
            currentNode = stack.pop();
            list.add(currentNode.getData());
            if(currentNode.getRight() != null) stack.push(currentNode.getRight());
            if(currentNode.getLeft() != null) stack.push(currentNode.getLeft());
        }
        return list.size();
    }

    public int height(BinarySearchTreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isSame(BinarySearchTreeNode root1, BinarySearchTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        boolean result = root1.getData() == root2.getData() && isSame(root1.getLeft(), root2.getLeft()) && isSame(root1.getRight(), root2.getRight());
        return result;
    }

    public boolean nonRecursiveIsSame(BinarySearchTreeNode root1, BinarySearchTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        BinarySearchTreeNode currentNode = root1;
        stack.push(currentNode);

        while(!stack.isEmpty()){
            currentNode = stack.pop();
            list1.add(currentNode.getData());
            if(currentNode.getRight() != null) stack.add(currentNode.getRight());
            if(currentNode.getLeft() != null) stack.add(currentNode.getLeft());
        }
        currentNode = root2;
        stack.push(currentNode);
        while(!stack.isEmpty()){
            currentNode = stack.pop();
            list2.add(currentNode.getData());
            if(currentNode.getRight() != null) stack.add(currentNode.getRight());
            if(currentNode.getLeft() != null) stack.add(currentNode.getLeft());
        }

        return list1.equals(list2);
    }

    public boolean rootToLeafSum(BinarySearchTreeNode root, int sum, List<Integer> result){
        if(root == null) return false;
        //Leaf node
        if(root.getLeft() == null && root.getRight() == null){
            if(root.getData() == sum){
                result.add(root.getData());
                return true;
            } else {
                return false;
            }
        }

        if(rootToLeafSum(root.getLeft(), sum - root.getData(), result)){
            result.add(root.getData());
            return true;
        } 
        if(rootToLeafSum(root.getRight(), sum - root.getData(), result)){
            result.add(root.getData());
            return true;
        }
        return false;
    }

    public boolean isBinarySearchTree(BinaryTreeNode root, int min, int max){
        if(root == null) return true;
        if(root.getData() < min || root.getData() > max) return false;
        return isBinarySearchTree(root.getLeft(), min, root.getData()) &&  isBinarySearchTree(root.getRight(), root.getData(), max);
    }

    public List<Integer> levelOrderTraversal(BinarySearchTreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            list.add(root.getData());
            if(root.getLeft() != null) queue.offer(root.getLeft());
            if(root.getRight() != null) queue.offer(root.getRight());
        }
        return list;
    }

    public void levelByLevelTraversalUsingTwoQueues(BinarySearchTreeNode root){
        if(root == null) return;
        Queue<BinarySearchTreeNode> queue1 = new LinkedList<>();
        Queue<BinarySearchTreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            while(!queue1.isEmpty()){
                root = queue1.poll();
                System.out.print(root.getData() +  " ");
                if(root.getLeft() != null) queue2.offer(root.getLeft());
                if(root.getRight() != null) queue2.offer(root.getRight());
            }
            System.out.println();
            while(!queue2.isEmpty()){
                root = queue2.poll();
                System.out.print(root.getData() + " ");
                if(root.getLeft() != null) queue1.offer(root.getLeft());
                if(root.getRight() != null) queue1.offer(root.getRight());
            }
            System.out.println();
        }
    }

    public void levelByLevelTraversalUsingOneQueueAndDelimiter(BinarySearchTreeNode root){
        if(root == null) return;
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root != null){
                if(root.getLeft() != null) queue.offer(root.getLeft());
                if(root.getRight() != null) queue.offer(root.getRight());
            } else {
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.offer(null);
                }
            }
        }
    }

    public void levelByLevelTraversalUsingOneQueueAndCounter(BinarySearchTreeNode root){
        if(root == null) return;
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;
        int currentCount = 0;
        while(!queue.isEmpty()){
            while(levelCount > 0){
                root = queue.poll();
                System.out.print(root.getData() + " ");
                if(root.getLeft() != null){
                    queue.offer(root.getLeft());
                    currentCount++;
                }
                if(root.getRight() != null){
                    queue.offer(root.getRight());
                    currentCount++;
                }
                levelCount--;
            }
            System.out.println();
            levelCount = currentCount;
            currentCount = 0;
        }
    }

    public List<Integer> levelOrderTraversalInReverse(BinarySearchTreeNode root){
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<BinarySearchTreeNode> queue = new LinkedList<>();
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            stack.push(root);
            if(root.getRight() != null) queue.offer(root.getRight());
            if(root.getLeft() != null) queue.offer(root.getLeft());
        }
        while(!stack.isEmpty()){
            BinarySearchTreeNode node = stack.pop();
            list.add(node.getData());
        }
        return list;
    }

    public List<Integer> levelOrderTraversalInSpiralOrder(BinarySearchTreeNode root){
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<BinarySearchTreeNode> stack1 = new Stack<>();
        Stack<BinarySearchTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()){
                root = stack1.pop();
                list.add(root.getData());
                if(root.getLeft() != null) stack2.push(root.getLeft());
                if(root.getRight() != null) stack2.push(root.getRight());
            }
            while(!stack2.isEmpty()){
                root = stack2.pop();
                list.add(root.getData());
                if(root.getRight() != null) stack1.push(root.getRight());
                if(root.getLeft() != null) stack1.push(root.getLeft());
            }
        }
        return list;
    }

    public BinarySearchTreeNode lowestCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode node1, BinarySearchTreeNode node2){
        if(root.getData() > Math.max(node1.getData(), node2.getData())){
            return lowestCommonAncestor(root.getLeft(), node1, node2);
        } else if(root.getData() < Math.min(node1.getData(), node2.getData())){
            return lowestCommonAncestor(root.getRight(), node1, node2);
        } else {
            return root;
        }
    }

    
    public List<Integer> morrisInorderTraversal(BinarySearchTreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root != null){
            BinarySearchTreeNode current = root;
            while(current != null){
                if(current.getLeft() == null){
                    list.add(current.getData());
                    current = current.getRight();
                } else {
                    BinarySearchTreeNode predecessor = current.getLeft();
                    while(predecessor.getRight() != null && predecessor.getRight() != current){
                        predecessor = predecessor.getRight();
                    }
                    if(predecessor.getRight() == null){
                        predecessor.setRight(current);
                        current = current.getLeft();
                    } else {
                        predecessor.setRight(null);
                        list.add(current.getData());
                        current = current.getRight();
                    }
                }
            }
        }
        return list;
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
