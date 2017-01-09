public class BinarySearchTree extends BinaryTree {

  public BinarySearchTree(Integer value) {
    super(value, null, null);
  }

  public BinarySearchTree insert(Integer value) {
    return insert(this, value);
  }

  public static BinarySearchTree complete(int depth, int base) {
    if (depth == 0) {
      return null;
    }
    BinarySearchTree tree = new BinarySearchTree (base + (int)Math.pow(2, depth-1));
    tree.left = complete(depth-1, base);
    tree.right = complete(depth-1, base + (int)Math.pow(2, depth-1));

//    tree.insert((int)Math.pow(2, depth-2));
//    tree.insert((int)Math.pow(2, depth-1) + (int)Math.pow(2, depth-2));
    return tree;
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
