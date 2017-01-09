import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTreeTest {
  @Test
  public void tree7() {
    BinarySearchTree tree = new BinarySearchTree(4);
    tree.insert(2);
    tree.insert(6);
    tree.insert(1);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    tree.dump();
  }

  @Test
  public void tree15() {
    BinarySearchTree tree = new BinarySearchTree(8);
    tree.insert(4);
    tree.insert(12);
    tree.insert(2);
    tree.insert(6);
    tree.insert(1);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    tree.insert(10);
    tree.insert(9);
    tree.insert(11);
    tree.insert(14);
    tree.insert(13);
    tree.insert(15);    
    tree.dump();
  }

  @Test
  public void testN() {
    BinarySearchTree tree = BinarySearchTree.complete(5, 0);
    tree.dump();
  }
}
