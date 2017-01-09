import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTreeTest {
  @Test
  public void construct() {
    BinarySearchTree tree = new BinarySearchTree(4);
    tree.insert(2);
    tree.insert(6);
    tree.insert(1);
    tree.insert(3);
    tree.insert(5);
    tree.insert(7);
    tree.dump();
  }
}