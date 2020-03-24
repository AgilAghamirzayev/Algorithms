package lists;

import java.util.LinkedList;
import java.util.Optional;

public class LinkedLists {
    public static void main(String[] args) {
        findMiddleElementLinkedList(new LinkedList<>());
    }
    public static Optional<String> findMiddleElementLinkedList(
            LinkedList<String> linkedList){
        if (linkedList == null || linkedList.isEmpty())
            return Optional.empty();
        return Optional.of(linkedList.get((linkedList.size() -1 )/2));
    }

}
