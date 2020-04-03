package trees;

public class AppB {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node node = new BinaryTree.Node(9);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(6);
        binaryTree.add(7);



        binaryTree.traversePostOrder(node);
    }
}
