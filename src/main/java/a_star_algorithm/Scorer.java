package a_star_algorithm;

public interface Scorer<T extends GraphNode>{
    double computeCost(T from, T to);
}
