/*
 * file: Node.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides a node/leaf for a binary tree
 * array implementation
 *
 * @author Justin Law
 * @version 1.0
 */

public class Node {

  private int weight;
  private String data;

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
   * Returns string representation of the node
   *
   * @return String
   */
  public String toString() {
    return String.format("%s: %d", this.data, this.weight);
  }

}
