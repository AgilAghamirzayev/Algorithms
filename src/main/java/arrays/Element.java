package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Element {
    private int id;

    public Element(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int compareTo(Element element){
        int res = 0;
        if (this.id < element.getId()){
            res = -1;
        }

        if (this.id > element.getId()){
            res = 1;
        }
        return res;
    }

    public static void insertionSortArrayList(List<Element> list){
        for (int i = 0; i < list.size(); i++) {
            Element current = list.get(i);
            int j = i-1;
            while ((j > -1) && ((list.get(j).compareTo(current))==1)){
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, current);
        }
    }

    public static void main(String[] args) {
        List<Element> list = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            list.add(new Element(i));
        }

        Collections.shuffle(list);

        // print lit before sorting
        list.forEach(e-> System.out.print(e.getId() + ", "));

        long startTime = System.nanoTime();
        // sort the list
        insertionSortArrayList(list);
        long endTime = System.nanoTime();
        System.out.println();
        list.forEach(s-> System.out.print(s.getId() + ", "));
        System.out.println();
        System.out.println("Insertion sort runtime: " + (endTime-startTime));

    }
}
