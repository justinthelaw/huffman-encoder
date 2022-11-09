/*
 * file: App.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class stores the main program execution instructions for Huffman
 * Encoding and Decoding
 *
 * @author Justin Law
 * @version 1.0
 */

public class App {
    public static void main(String[] args) throws Exception {
        Node nodeX = new Node(3, "X");
        Node nodeY = new Node(1, "Y");
        Node nodeZ = new Node(2, "Z");
        Node[] nodeArr = {nodeY, nodeZ, nodeX};
        BinaryTree tree = new BinaryTree(nodeArr);
        System.out.println(tree.toString());
    }
}
