package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree bt = new BinaryTree();

   @Test
    public  void givenSBinaryTree_WhenAddingElements_ThenTreeContainsThoseElements(){
     bt.add(7);
     bt.add(9);

     assertTrue(bt.containsNode(7));
     assertTrue(bt.containsNode(9));

   }

   @Test
   public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
       bt.add(7);
       bt.add(9);
       assertTrue(bt.containsNode(9));
       bt.delete(9);
       assertFalse(bt.containsNode(9));
   }
}