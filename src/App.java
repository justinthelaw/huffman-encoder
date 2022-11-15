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
            InputMismatchException, NumberFormatException, NullPointerException {
        // read frequency table and transform into Nodes
        // size is total expected characters
        Node[] nodeArr = ReadWrite.frequencyListRead(args[1]);

        // storage of all tracked metrics:
        // 1) huffman tree creation, 2) code table generation, 3) encode/decode
        Metrics metrics = new Metrics(3);
        // new runtime metric for huffman tree creation and merge sorts
        RuntimeMetric preorderTreeMetric = new RuntimeMetric(nodeArr.length);
        // start metric time
        preorderTreeMetric.start();

        // sort Nodes in ascending order based on weight
        // if weight is equal, use lexicographic value
        MergeSort.sort(nodeArr, 0, nodeArr.length - 1);
        // generate the Huffman Binary Tree
        HuffmanBinaryTree tree = new HuffmanBinaryTree(nodeArr);

        // end metric time
        preorderTreeMetric.end();
        metrics.storeMetric(preorderTreeMetric);

        // write the preorder traversal of the binary tree to file
        // use input filename as a prefix to output filename
        String base = "output/" + args[1].substring(6, args[1].lastIndexOf("."));
        String outputPreorder = base + "-PreorderTree.txt";
        ReadWrite.write(outputPreorder, tree.toString());

        // new runtime metric for code table creation
        RuntimeMetric codeTableMetric = new RuntimeMetric(nodeArr.length);
        // start metric time
        codeTableMetric.start();

        // generate code table based on the Huffman Binary Tree
        HuffmanEncoder codeTable = new HuffmanEncoder(nodeArr.length);
        codeTable.generateEncodingTable(tree);
        String outputCodeTable = base + "-CodeTable.txt";
        ReadWrite.write(outputCodeTable, codeTable.toString());

        // end metric time
        codeTableMetric.end();
        metrics.storeMetric(codeTableMetric);

        // check if the user is encoding or decoding files
        base = "output/" + args[2].substring(6, args[1].lastIndexOf("."));
        if (args[0].toLowerCase().compareTo("encode") == 0) {
            // filename and message for user
            String outputEncoded = base + "-Encoded.txt";
            System.out.println("Encoding " + args[2] + " and outputting to " + outputEncoded);

            String clearText = ReadWrite.clearTextRead(args[2]);
            // new runtime metric for code table creation
            RuntimeMetric encodeMetric = new RuntimeMetric(clearText.length());
            // start metric time
            encodeMetric.start();

            // encode the clear text
            String codedText = "";
            try {
                codedText = codeTable.encode(clearText);
            } catch (NullPointerException e) {
                FormatError.printError(e, "");
            }

            // end metric time
            encodeMetric.end();
            metrics.storeMetric(encodeMetric);

            // write coded text to file
            ReadWrite.write(outputEncoded, codedText);
            // write associated metrics to file
            ReadWrite.write(base + "-Encoded-Metrics.csv", metrics.toString());
        } else {
            // filename and message for user
            String outputDecoded = base + "-Decoded.txt";
            System.out.println("Decoding " + args[2] + " and outputting to " + outputDecoded);
        }

    }
}
