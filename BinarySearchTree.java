public class BinarySearchTree extends BinaryTree {

  /**
    * Create a node of a BST without child 
    */
  public BinarySearchTree(Integer value) {
    super(value, null, null);
  }


  public BinarySearchTree(int depth, int base) {
    this(base + (int) Math.pow(2, depth - 1));
    if (depth > 1) {
      left = new BinarySearchTree(depth - 1, base);
      right = new BinarySearchTree(depth - 1, base + (int) Math.pow(2, depth - 1));
    }
  }

  /**
    * Insert a new value in the BST
    * @value the new value to insert
    * @time O(log(n))
    */
  public BinarySearchTree insert(Integer value) {
    return insert(this, value);
  }

  /**
    * Delete an element from a BST 
    * @time O(log(n))
    */
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

  private Integer getMinNode() {
    if (left == null) {
      return value;
    } else {
      return ((BinarySearchTree)left).getMinNode();
    }
  }

  private BinarySearchTree deleteMinNode() {
    if (left.left == null) {
      left = null;
      return this;
    } else {
      return ((BinarySearchTree)left).deleteMinNode();
    }
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
