import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryTreeTest {
  @Test
  public void construct() {
    BinaryTree left = new BinaryTree(1, null, null);
    BinaryTree right = new BinaryTree(3, null, null);
    BinaryTree root = new BinaryTree(2, left, right);

    root.dump();
  }
}