public class BinaryTree {
  Integer value;
  BinaryTree left;
  BinaryTree right;

  public BinaryTree(Integer value, BinaryTree left, BinaryTree right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public void dump() {
    int depth = depth(this);

    BinaryTree[] nodes = new BinaryTree[1];
    nodes[0] = this;
    System.out.println();
    dumpLine(nodes, depth);
  }

  // Static
  public static int depth(BinaryTree tree) {
    if (tree == null) {
      return 0;
    }
    return Math.max(depth(tree.left), depth(tree.right)) + 1;
  }

  private static void dumpLine(BinaryTree[] nodes, int spaces) {
    BinaryTree[] nextNodes = new BinaryTree[nodes.length * 2];
    Boolean added = false;
    for (int i = 0; i < nodes.length; i++) {
      BinaryTree node = nodes[i];
      for (int s = 0; s < Math.pow(2, spaces) - 1; s++) {
        System.out.print("   ");
      }
      if (node != null) {
        System.out.format("%03d", node.value);
        nextNodes[2 * i] = node.left;
        nextNodes[2 * i + 1] = node.right;
        added = true;
      } else {
        System.out.print(" . ");
      }
      for (int s = 0; s < Math.pow(2, spaces); s++) {
        System.out.print("   ");
      }
    }
    System.out.println();
    if (added) {
      dumpLine(nextNodes, spaces - 1);
    }
  }
}