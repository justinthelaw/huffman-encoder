import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;

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
    public static void main(String[] args) throws FileNotFoundException, IOException,
            InputMismatchException, NumberFormatException {
        // read frequency table and transform into Nodes
        // size is total expected characters
        Node[] nodeArr = ReadWrite.frequencyListRead(args[1]);
        // // Test Nodes from project description
        // Node x = new Node(3, "x");
        // Node y = new Node(2, "y");
        // Node z = new Node(1, "z");
        // Node[] nodeArr = new Node[]{x, y, z};
        // sort Nodes in ascending order based on weight
        // if weight is equal, use lexicographic value
        MergeSort.sort(nodeArr, 0, nodeArr.length - 1);
        // generate the Huffman Binary Tree
        HuffmanBinaryTree tree = new HuffmanBinaryTree(nodeArr);
        // write the preorder traversal of the binary tree to file
        // use input filename as a prefix to output filename
        String base = "output/" + args[1].substring(6, args[1].lastIndexOf("."));
        String outputPreorder = base + "-PreorderTree.txt";
        ReadWrite.write(outputPreorder, tree.toString());
        // generate code table based on the Huffman Binary Tree
        HuffmanEncoder codeTable = new HuffmanEncoder(nodeArr.length);
        codeTable.generateEncodingTable(tree);
        String outputCodeTable = base + "-CodeTable.txt";
        ReadWrite.write(outputCodeTable, codeTable.toString());
    }
}
