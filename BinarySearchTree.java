public class BinarySearchTree extends BinaryTree {

  public BinarySearchTree(Integer value) {
    super(value, null, null);
  }

  /**
    * Insert a new value in the BST
    * @value the new value to insert
    * @time O(log(n))
    */
  public BinarySearchTree insert(Integer value) {
    return insert(this, value);
  }

  public BinarySearchTree delete(Integer value) {
    if (value < this.value) {
      left = ((BinarySearchTree) left).delete(value);
    } else if (value > this.value) {
      right = ((BinarySearchTree) right).delete(value);
    } else { // equals
      if (left != null && right != null) {
        this.value = ((BinarySearchTree)right).getMinNode();
        this.right = ((BinarySearchTree)right).deleteMinNode();
        return this;
      } else if (left != null) {
        return (BinarySearchTree) left;
      } else if (right != null) {
        return (BinarySearchTree) right;
      } else {
        return null;
      }
    }
    return this;
  }

  public Integer getMinNode() {
    if (left == null) {
      return value;
    } else {
      return ((BinarySearchTree)left).getMinNode();
    }
  }

  public BinarySearchTree deleteMinNode() {
    if (left.left == null) {
      left = null;
      return this;
    } else {
      return ((BinarySearchTree)left).deleteMinNode();
    }
  }

  public static BinarySearchTree complete(int depth, int base) {
    if (depth == 0) {
      return null;
    }
    BinarySearchTree tree = new BinarySearchTree(base + (int) Math.pow(2, depth - 1));
    tree.left = complete(depth - 1, base);
    tree.right = complete(depth - 1, base + (int) Math.pow(2, depth - 1));
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
