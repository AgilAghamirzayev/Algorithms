package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public void add(int value){
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value){
            if (current == null) return new Node(value);

            if (value < current.value) current.left = addRecursive(current.left, value);
            else if (value > current.value) current.right = addRecursive(current.right,value);
            else return current;
            return current;
    }



        private boolean containsNodeRecursive(Node current, int value){
            if (current == null) return false;
            if (value == current.value) return true;
            return value < current.value
                    ? containsNodeRecursive(current.left, value)
                    : containsNodeRecursive(current.right, value);
        }

        public boolean containsNode(int value){
            return containsNodeRecursive(root, value);
        }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

        private Node deleteRecursive(Node current, int value) {
            if (current == null) return null;

            if (value == current.value) {
                // a node has no child
                if (current.left == null && current.right == null) return null;

                //a node has exactly one child
                if (current.right == null) return current.left;
                if (current.left == null) return current.right;

                // a node has two children
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }

            if (value<current.value){
                current.left = deleteRecursive(current.left,value);
                return current;
            }

            current.right = deleteRecursive(current.right,value);
            return current;
        }

        public void traverseInOrder(Node node){
          if (node!= null){
              traverseInOrder(node.left);
              System.out.println(" " + node.value);
              traverseInOrder(node.right);
          }
        }

        public void traversePreOrder(Node node){
            if (node != null){
                System.out.println(" " + node.value);
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }

        public void traversePostOrder(Node node){
            if (node != null){
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.println(" " + node.value);
            }
        }

        public void traverseOrder(){
        if (root == null) return;
            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()){
                Node node = nodes.remove();
                System.out.println(" " + node.value);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
        }


        private int findSmallestValue(Node root){
            return root.left == null ? root.value : findSmallestValue(root.left);
        }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

}
