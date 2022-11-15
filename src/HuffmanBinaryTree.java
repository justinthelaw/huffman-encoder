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
  private String preorderString;

  /**
   * Constructor to create the Binary Tree from an array of Nodes with attributes
   * of weight (int) and data (String)
   *
   * Pre-conditions: a pre-ordered array of inputs, in ascending order of weight,
   * where tie breaks are based on String’s number of characters (xy < abcd)
   * relative to the one it is tied with, and then lexicographically (a < b)
   *
   * @param Node tree head
   */
  public HuffmanBinaryTree(Node[] nodes) {
    // build Huffman Encoding binary tree using min-heap sub-trees
    while (nodes[0] != null && nodes[1] != null) {
      nodes[0] = buildSubTree(nodes[0], nodes[1]);
      nodes[1] = null;
      MergeSort.sort(nodes, 0, nodes.length - 1);
    }
    this.root = nodes[0];

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
   * @param String stores the preorder print
   */
  public void preorder(Node node, String string) {
    // null node means an end of the tree
    if (node == null) {
      return;
    }
    // add the string
    this.preorderString += String.format("%s=%d\n", node.data(), node.weight());
    // preorder traverses left before right nodes
    preorder(node.left(), string);
    preorder(node.right(), string);
  }

  /**
   * Wrapper for preorder traversal method
   *
   */
  public void preorder(Boolean b) {
    // wipe previous data from traversal
    this.preorderString = "";
    preorder(this.root, "");
    if (b)
      System.out.println(this.preorderString.trim());
  }

  /**
   * Override String return to be preorder print of binary tree
   *
   * @return String
   */
  @Override
  public String toString() {
    this.preorder(false);
    return this.preorderString.trim();
  }

}
