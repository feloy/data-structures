public class BinarySearchTree extends BinaryTree {

  public BinarySearchTree(Integer value) {
    super(value, null, null);
  }

  public BinarySearchTree insert(Integer value) {
    return insert(this, value);
  }

  private static BinarySearchTree insert(BinarySearchTree node, Integer value) {
    if (node == null) {
      return new BinarySearchTree(value);
    } else if (value < node.value) {
      node.left = insert((BinarySearchTree) node.left, value);
      return node;
    } else {
      node.right = insert((BinarySearchTree) node.right, value);
      return node;
    }
  }
}
