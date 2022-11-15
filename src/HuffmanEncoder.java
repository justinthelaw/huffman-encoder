
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
   * Traverse (preorder) Huffman Binary Tree and assign a code to each character
   *
   * @param HuffmanBinaryTree
   * @param String            code
   * @param String            add, the 1 or 0 to be added to the code
   */
  public void generateEncodingTable(Node node, String code, String add) {
    // null node means an end of the tree
    if (node == null) {
      return;
    }

    // add the direction taken (right = 1 or left = 0)
    code += add;

    // preorder traverses left before right nodes
    generateEncodingTable(node.left(), code, "0");
    generateEncodingTable(node.right(), code, "1");

    // leaf nodes don't have chuldren, and are characters for code table
    if (node.left() == null && node.right() == null) {
      encodingTable.insert(node.data(), code);
    }

  }

  /**
   * Wrapper for encoding table generation method
   *
   * @param HuffmanBinaryTree
   */
  public void generateEncodingTable(HuffmanBinaryTree tree) {
    generateEncodingTable(tree.getRoot(), "", "");
  }

  /**
   * Encodes a string of text with existing huffman coding table
   *
   * @param String clear text
   *
   * @return String encoded text
   */
  public String encode(String clearText) throws NullPointerException {
    String encoded = "";

    for (int i = 0; i < clearText.length(); i++) {
      String character = clearText.charAt(i) + "";
      String code = encodingTable.get(character);
      if (code == null) {
        throw new NullPointerException("The Huffman Encoding table does not contain: " + character);
      }
      encoded += code;
    }

    return encoded;
  }

  /**
   * Override String return to be key-value pairs print
   *
   * @return String
   */
  @Override
  public String toString() {
    String[] arr = this.encodingTable.toString().split(", ");
    String s = "";
    for (int i = 0; i < arr.length; i++) {
      s += arr[i] + "\n";
    }
    s = s.trim().substring(1, s.length() - 2);
    return s;
  }

}
