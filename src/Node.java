/*
 * file: Node.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides a node or leaf for a binary tree
 * array or linked list or doubly linked list implementation
 *
 * @author Justin Law
 * @version 1.0
 */

public class Node {

  private int weight;
  private String data;
  private Node left;
  private Node right;
  private Node parent;

  /**
   * Constructor to create the Node
   *
   * @param weight
   */
  public Node(int weight, String data) {
    this.weight = weight;
    this.data = data;
    return;
  }

  /**
   * Overloaded constructor to create a linked Node
   *
   * @param weight
   */
  public Node(int weight, String data, Node left, Node right) {
    this.weight = weight;
    this.data = data;
    this.left = left;
    this.right = right;
    return;
  }

  /**
   * Sets the node's weight
   *
   * @param weight
   * @return int weight that was set
   */
  public int setWeight(int weight) {
    this.weight = weight;
    return this.weight;
  }

  /**
   * Sets the node's data
   *
   * @param data
   * @return T data that was set
   */
  public String setData(String data) {
    this.data = data;
    return this.data;
  }

  /**
   * Gets and returns nodes's weight
   *
   * @return int weight
   */
  public int weight() {
    return this.weight;
  }

  /**
   * Gets and returns data of node
   *
   * @return String data
   */
  public String data() {
    return this.data;
  }

  /**
   * Gets and returns parent node
   *
   * @return Node parent
   */
  public Node parent() {
    return this.parent;
  }

  /**
   * Gets and returns left child node
   *
   * @return Node left
   */
  public Node left() {
    return this.left;
  }

  /**
   * Gets and returns right child node
   *
   * @return Node right
   */
  public Node right() {
    return this.right;
  }

  /**
   * Sets parent node
   *
   * @param Node
   * @return Node parent
   */
  public Node setParent(Node node) {
    this.parent = node;
    return node;
  }

  /**
   * Sets left child node
   *
   * @param Node
   * @return Node left
   */
  public Node setLeft(Node node) {
    this.left = node;
    return node;
  }

  /**
   * Sets right child node
   *
   * @param Node
   * @return Node right
   */
  public Node setRight(Node node) {
    this.right = node;
    return node;
  }

  /**
   * Returns string representation of the node
   *
   * @return String
   */
  @Override
  public String toString() {
    return String.format("%s: %d", this.data, this.weight);
  }
}
