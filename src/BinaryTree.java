/*
 * file: BinaryTree.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides an array implementation of a String binary tree with
 * methods for traversal, creation, insertion and printing
 *
 * @author Justin Law
 * @version 1.0
 */

public class BinaryTree {

  // 0th node does not get used in this implementation
  private Node[] tree;
  private int size;

  /**
   * Constructor to create the Binary Tree from an array of nodes
   *
   * Pre-conditions: a pre-ordered array of inputs, in ascending order of weight,
   * where tie breaks are beased on alphabetical order
   * Example Input: [ {weight: 6, data: Z}, {weight: 20, data: R},
   * {weight: 45, data: V}, {weight: 45, data: G} ]
   *
   * @param Node[] nodes
   */
  public BinaryTree(Node[] nodes) {
    // set the max size, 2^n nodes for Huffman Encoding
    this.size = (int) Math.pow(2, nodes.length) - 1;
    // initialize tree array
    this.tree = new Node[size];
    // find left and right children
    Node left = nodes[0];
    Node right = nodes[1];
    // initialize the parent node parameters
    int weight = left.weight() + right.weight();
    String data = left.data() + right.data();
    Node parent = new Node(weight, data);
    // parent is at parentIndex
    int parentIndex = (this.size - 2) / 2;
    this.tree[parentIndex] = parent;
    // left is at parentIndex * 2
    int leftIndex = this.size - 2;
    this.tree[leftIndex] = left;
    // right is at parentIndex * 2 + 1
    int rightIndex = this.size - 1;
    this.tree[rightIndex] = right;

    if (nodes.length > 2) {
      // add-on to base tree all upper nodes
      for (int i = 2; i < nodes.length; i++) {
        rightIndex = parentIndex;
        parentIndex = (rightIndex / 2) - 1;
        left = nodes[i];
        leftIndex = parentIndex * 2;
        this.tree[leftIndex] = left;
        weight += left.weight();
        data += left.data();
        parent = new Node(weight, data);
        this.tree[parentIndex] = parent;
      }
    }
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
    return tree[1];
  }

  /**
   * String representation of the binary tree
   * Pre-order traversal
   *
   * @return String
   */
  public String toString() {
    String string = "";
    for (int i = 1; i < this.size; i++) {
      if (tree[i] != null) {
        string += "{ " + tree[i].toString() + " }";
        if (i != this.size - 1) {
          string += ", ";
        }
      }
    }
    return string;
  }

}
