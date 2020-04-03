package trees;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class XTree<K extends Comparable<K>, V> {

    class Node{

        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // runner part
    public void add(K key, V value){
        root = add(root,key,value);
    }

    // recursive part
    public Node add(Node x, K key, V value){
        if (x == null) return new Node(key, value);  // null -> creating
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = add(x.left, key, value);
        else if (cmp>0) x.right = add(x.right,key,value);
        else x.value = value;
        return x;
    }

    //runner part
    public Optional<V> get(K key){
        return get(root, key);
    }

    //recursive part
    private Optional<V> get(Node x, K key){
        if (x == null) return Optional.empty();
        int cmp  = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return Optional.of(x.value);

    }

    // runner part
    public void remove(K key){
        root = remove(root, key);
    }

    //recursive part
    private Node remove(Node x, K key){
        if (x == null ) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = remove(x.left, key);
        if (cmp>0) x.right = remove(x.right,key);
        else {
            // left is empty. just pull-up right
            if (x.left == null) return x.right;
            // right is empty. just pull-up right
            if (x.right == null) return x.left;
            // both occupied, need more work
            x = performNodeRemoval(x);
        }
        return x;
    }

    private Node performNodeRemoval(Node x){
        // 1. save the left sub-tree. we will attach in 4.3
        Node saveLeft = x.left;
        // 2. find the minimal in the right sub-tree.
        // It will be new instead of deleted
        Node newNode = findMinFrom(x.right);
        // 3. remove the minimal from the right sub-tree
        Node newRight = deleteMinAndPullUpFrom(x.right);
        // 4.2. attach new right
        newNode.right = newRight;
        // 4.2. attach new left
        newNode.left = saveLeft;
        return newNode;

    }

    private Node findMinFrom(Node x){
        return x.left == null ? x : findMinFrom(x.left);
    }

    private Node deleteMinAndPullUpFrom(Node x){
        // left is empty. we found it. skip it. just pull-up right. return right sub-tree
        if (x.left == null) return x.right;
        // we didn't find. need go left to find it
        x.left = deleteMinAndPullUpFrom(x.left);
        return x;
    }

    public Set<K> keys(){
        HashSet<K> keys = new HashSet<>();
        processNode(root, keys);
        return keys;
    }

    private void processNode(Node x, Set<K> acc){
        if (x == null) return;
        acc.add(x.key);
        processNode(x.left, acc);
        processNode(x.right, acc);
    }

}
