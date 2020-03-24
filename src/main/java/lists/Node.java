package lists;

public class Node {
    private Node next;
    private String data;

    public Node(Node next, String data) {
        this.next = next;
        this.data = data;
    }

    public Node(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean hasNext(){
        return next != null;
    }

    public String toString(){
        return  this.data;
    }

    private static Node createNodeList(int n){
        Node head = new Node("1");
        Node current = head;

        for (int i = 2; i <n ; i++) {
            Node newNode = new Node(String.valueOf(i));
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }
}

