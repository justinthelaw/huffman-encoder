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
        Node[] nodeArr = ReadWrite.frequencyListRead(args[0]);
        MergeSort.sort(nodeArr, 0, nodeArr.length - 1);
        BinaryTree tree = new BinaryTree(nodeArr);
        System.out.println(tree.toString());
    }
}
