package travelling_salesman_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestNeighbour {
    public Route findShortestRoute(ArrayList<Node> nodes) {
        ArrayList<Node> shortestRouteCities = new ArrayList<>();
        System.out.println("--------------------------------------------------------");
        System.out.println("Initial Rote:        ==> " + Arrays.toString(nodes.toArray()));
        System.out.println("w/ total distance: " + new Route(nodes).calculateTotalTime());
        System.out.println("--------------------------------------------------------");

        Node node = nodes.get((int) (nodes.size() * Math.random()));
        updateRoutes(shortestRouteCities, nodes, node);

        while (nodes.size() >= 1) {
            Node nextNode = getNextNode(nodes, node);
            updateRoutes(shortestRouteCities, nodes, nextNode);
        }

        return new Route(shortestRouteCities);
    }

    private void updateRoutes(ArrayList<Node> shortestRouteCities, ArrayList<Node> nodes, Node node) {
        shortestRouteCities.add(node);
        nodes.remove(node);
        System.out.println("Nodes In Short Route ==> " + Arrays.toString(shortestRouteCities.toArray()));
        System.out.println("Remaining Node       ==> " + Arrays.toString(nodes.toArray()) + "\n");
    }

    private Node getNextNode(ArrayList<Node> nodes, Node node) {
        return nodes.stream().min((node1, node2) -> {
            int flag = 0;
            if      (node1.measureTime(node) < node2.measureTime(node)) flag = -1;
            else if (node1.measureTime(node) > node2.measureTime(node)) flag =  1;

            return flag;
        }).get();
    }
}
