package travelling_salesman_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Courier {

    ArrayList<Node> initNode = new ArrayList<>(
            Arrays.asList(
                    new Node("R1", 7),
                    new Node("M1", 1),
                    new Node("R2", 8),
                    new Node("M2", 9)
            )
    );

    public static void main(String[] args) {

        Courier courier = new Courier();
        ArrayList<Node> nodes = new ArrayList<>(courier.initNode);
        courier.printShortestNode(new NearestNeighbour().findShortestRoute(nodes));

    }

    private void printShortestNode(Route route) {
        System.out.println("----------------------------------------------");
        System.out.println("Shortest node found so for: " + route);
        System.out.println("w/ total distance: " + route.calculateTotalTime());
        System.out.println("----------------------------------------------");
    }
}
