package graph;

public class AppA {
    public static void main(String[] args) {
        GraphTraversal gt = new GraphTraversal();
        System.out.println("     Depth First Traversal");
        System.out.println(gt.depthFirstTraversal(createGraph(),"Bob"));
        System.out.println(gt.depthFirstTraversal(createGraph(),"Rob"));
        System.out.println(gt.depthFirstTraversal(createGraph(),"Alice"));
        System.out.println(gt.depthFirstTraversal(createGraph(),"Mark"));
        System.out.println(gt.depthFirstTraversal(createGraph(),"Maria"));

        System.out.println();
        System.out.println("    Breadth First Traversal");
        System.out.println(gt.breadthFirstTraversal(createGraph(),"Bob"));
        System.out.println(gt.breadthFirstTraversal(createGraph(),"Rob"));
        System.out.println(gt.breadthFirstTraversal(createGraph(),"Alice"));
        System.out.println(gt.breadthFirstTraversal(createGraph(),"Mark"));
        System.out.println(gt.breadthFirstTraversal(createGraph(),"Maria"));
    }

    public static Graph createGraph(){
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}
