package travelling_salesman_problem;

import java.util.Date;

public class Node {
    private String name;
    private double time;

    public Node(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public double measureTime(Node node) {
        return node.time - this.time;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
