/*
 * file: ReadWrite.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides standard buffered reading and writing of data
 * to an input and output file, string-by-string
 *
 * Modified from project-02 to apply to a binary tree and binary tree node
 * handling strings
 *
 * @author Justin Law
 * @version 1.2
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadWrite {

  /**
   * Buffered read of a file formatted with data on each line. Meant to read
   * line-by-line performing a check on each string.
   *
   * @param input  file location as a string
   * @return Node[] containing the data
   */
  public static Node[] frequencyListRead(String input) throws FileNotFoundException, IOException {
    Node[] frequencyList = new Node[26];
    // try with resource, buffered file read on file at location
    try (BufferedReader bufferedInputData = new BufferedReader(
        new FileReader(new File(input)))) {
      // read line-by-line, until no strings are left in the file
      String s;
      int i = 0;
      while ((s = bufferedInputData.readLine()) != null) {
        String c = s.substring(0, 1);
        int w = Integer.parseInt(s.substring(4));
        Node node = new Node(w, c);
        frequencyList[i] = node;
        i++;
      }
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path invalid");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data");
    }
    return frequencyList;
  }

  /**
   * Buffered output of a data to a file. Prints entire line of formatted data
   *
   * @param output file location as a string
   * @param data   formatted data
   * @return BinaryTree containing the data
   */
  public static void write(String output, String data)
      throws FileNotFoundException, IOException {
    // try with resource, buffered file output to file at location
    try (BufferedWriter bufferedOutputData = new BufferedWriter(
        new FileWriter(output, true))) {
      // write new data
      bufferedOutputData.write(data);
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path not invalid");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data");
    }
    return;
  }

}
