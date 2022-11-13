
/*
 * file: HuffmanEncoder.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class performs the transformations required to use the HUffman Binary
 * Tree for encoding and decoding data
 *
 * @author Justin Law
 * @version 1.0
 */

public class HuffmanEncoder {

  private Dictionary encodingTable;

  /**
   * Constructor for dictionary with N elements
   *
   * @param int number of entries
   */
  public HuffmanEncoder(int n) {
    this.encodingTable = new Dictionary(n);
  }

  /**
   * Traverse Huffman Binary Tree and assign a code to each character
   *
   * @param HuffmanBinaryTree
   */
  public void generateEncodingTable(Node node, String code) {
    if (node == null) {
      return;
    }

    if (node.left() == null && node.right() == null) {
      encodingTable.insert(node.data(), code);
    }

    code += "0";
    generateEncodingTable(node.left(), code);
    code += "1";
    generateEncodingTable(node.right(), code);
  }

  /**
   * Wrapper for encoding table generation method
   *
   */
  public void generateEncodingTable(HuffmanBinaryTree tree) {
    generateEncodingTable(tree.getRoot(), "");
  }

  /**
   * Override String return to be key-value pairs print
   *
   * @return String
   */
  @Override
  public String toString() {
    return this.encodingTable.toString();
  }

}
