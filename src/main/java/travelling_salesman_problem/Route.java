package travelling_salesman_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class Route {

    ArrayList<Node> nodes = new ArrayList<>();

    public Route(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int calculateTotalTime() {
        int nodeSize = this.getNodes().size();

       return (int) (nodes.stream().mapToDouble(value -> {
           int nodeIndex = this.getNodes().indexOf(value);
           double returnValue = 0;
           if (nodeIndex < nodeSize -1) returnValue = value.measureTime(this.getNodes().get(nodeIndex + 1));
           return returnValue;
       }).sum() + this.getNodes().get(nodeSize - 1).measureTime(this.getNodes().get(0)));
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes.toArray());
    }
}
