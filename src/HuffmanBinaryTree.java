/*
 * file: BinaryTree.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides a DLL implementation of a String binary tree with
 * methods for traversal, creation, insertion and printing
 *
 * @author Justin Law
 * @version 1.0
 */

public class HuffmanBinaryTree {

  // 0th node does not get used in this implementation
  private Node root;
  private int size;
  private String preorderString;

  /**
   * Constructor to create the Binary Tree from an array of Nodes with attributes
   * of weight (int) and data (String)
   *
   * Pre-conditions: a pre-ordered array of inputs, in ascending order of weight,
   * where tie breaks are based on String’s number of characters (xy < abcd)
   * relative to the one it is tied with, and then alphabetically (a < b)
   *
   * @param Node tree head
   */
  public HuffmanBinaryTree(Node[] nodes) {
    // set the max size, 2^n nodes for Huffman Encoding binary tree
    this.size = (int) Math.pow(2, nodes.length) - 1;
    // binary sub-trees storage array
    Node[] subTree = new Node[size / 2];
    int j = 0; // counter for sub-tree storage
    for (int i = 0; i < nodes.length; i += 2) {
      if ((i + 1) < nodes.length) {
        subTree[j] = buildSubTree(nodes[i], nodes[i + 1]);
      } else {
        // odd number of characters edge case
        subTree[j] = nodes[i];
      }
      j++;
    }
    this.root = subTree[0];
    // combine to generate Huffman Encoding binary tree
    for (int i = 1; i < j; i++) {
      // intialize the weight and data for the new subtree
      // initialize new parent for subtree
      int weight = this.root.weight() + subTree[i].weight();
      String data = subTree[i].data();
      Node parent = new Node(weight, data, this.root, subTree[i]);
      // determine left and right child nodes
      if (this.root.weight() < subTree[i].weight()) {
        data = this.root.data() + subTree[i].data();
        parent.setData(data);
      } else {
        data += this.root.data();
        parent.setData(data);
        parent.setLeft(subTree[i]);
        parent.setRight(this.root);
      }
      this.root = parent;
    }

  }

  /**
   * Takes in two nodes, builds a parent node, and generates a binary sub-tree
   *
   * @return Node binary sub-tree
   */
  private Node buildSubTree(Node firstNode, Node secondNode) {
    // smaller node weight is always the left child
    Node left = firstNode;
    Node right = secondNode;
    // initialize the parent node parameters
    int weight = left.weight() + right.weight();
    String data = right.data() + left.data();
    Node parent = new Node(weight, data, left, right);
    return parent;
  }

  /**
   * Gets and returns the number of empty and non-empty nodes in the tree
   *
   * @return int size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Gets and returns the root of the tree
   *
   * @return Node
   */
  public Node getRoot() {
    return this.root;
  }

  /**
   * Recursive print of the binary tree in preorder traversal
   *
   * @param Node
   */
  public void preorder(Node node, String string) {
    if (node == null) {
      return;
    }

    this.preorderString += String.format("%s: %d\n", node.data(), node.weight());
    preorder(node.left(), string);
    preorder(node.right(), string);
  }

  /**
   * Wrapper for preorder traversal method
   *
   */
  public void preorder() {
    // wipe previous data from traversal
    this.preorderString = "";
    preorder(this.root, "");
    System.out.println(this.preorderString.trim());
  }

  /**
   * Override String return to be preorder print of binary tree
   *
   * @return String
   */
  @Override
  public String toString() {
    this.preorder();
    return this.preorderString.trim();
  }

}
