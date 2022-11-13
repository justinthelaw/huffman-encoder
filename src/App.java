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
        Node[] nodeArr = ReadWrite.frequencyListRead(args[1]);
        MergeSort.sort(nodeArr, 0, nodeArr.length - 1);
        HuffmanBinaryTree tree = new HuffmanBinaryTree(nodeArr);
        String outputPreorder = "output/" + args[1].substring(6, args[1].lastIndexOf(".")) + "-PreorderTree.txt";
        ReadWrite.write(outputPreorder, tree.toString());
        HuffmanEncoder codeTable = new HuffmanEncoder(26);
        codeTable.generateEncodingTable(tree);
        System.out.println(codeTable.toString());
    }
}
