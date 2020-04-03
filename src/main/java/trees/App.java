package trees;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    public static void main1(String[] args) {
        XTree<Integer, String> tree = new XTree<>();
        tree.add(30,"Jim");
        tree.add(20,"John");
        tree.add(40,"Jeremy");

        System.out.println(tree.get(20));
        System.out.println(tree.get(30));
        System.out.println(tree.get(40));

    }

    public static void main(String[] args) {
        List<Integer> data = new Random().ints(10, 100)
                .limit(20).boxed().distinct()
                .collect(Collectors.toList());

        System.out.println(data);
        XTree<Integer, Integer> tree = new XTree<>();
        data.forEach(el -> tree.add(el, el));
        System.out.println(tree.keys());
        tree.remove(data.get(0));
        System.out.println(tree.keys());
    }
}
