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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;

public class ReadWrite {

  /**
   * Buffered read of a file formatted with data on each line. Meant to read
   * string-by-string performing a check on each string
   *
   * @param input  file location as a string
   * @param int    lines to skip during read
   * @param checks to be performed on each read item
   * @return BinaryTree containing the data
   */
  public static GenericBinaryTree<GenericBinaryTreeNode> bufferedRead(String input, int linesToSkip, Method check)
      throws FileNotFoundException, IOException, IllegalAccessException, IllegalArgumentException,
      InvocationTargetException, InputMismatchException {
    GenericBinaryTree<GenericBinaryTreeNode> prefixList = new GenericBinaryTree<>();
    String currentCheck = "";
    // try with resource, buffered file read on file at location
    try (BufferedReader bufferedInputData = new BufferedReader(
        new FileReader(new File(input)))) {
      // move to line of interest
      for (int line = 0; line < linesToSkip; line++) {
        bufferedInputData.readLine();
      }
      // read string-by-string, until no strings are left on line
      int i;
      while ((i = bufferedInputData.read()) != -1) {
        char c = (char) i;
        if (c == '\n' || c == '\r') {
          break;
        }
        currentCheck = check.getName();
        Object result = check.invoke(null, c);
        if ((boolean) result == false) {
          prefixList.empty();
          throw new InputMismatchException("Invalid data \"" + c + "\"");
        } else {
          prefixList.insertAtEnd(new GenericBinaryTreeNode<String>(c));
        }
      }
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path not invalid");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data");
    } catch (IllegalAccessException e) {
      FormatError.printError(e, "Method not callable by this class for: " + currentCheck + "()");
    } catch (IllegalArgumentException e) {
      FormatError.printError(e, "Incorrect arguments or argument types for: " + currentCheck + "()");
    } catch (InvocationTargetException e) {
      FormatError.printError(e, "Underlying method exception for: " + currentCheck + "()");
    } catch (InputMismatchException e) {
      FormatError.printError(e, "Line #" + (linesToSkip + 1) + " failed to pass " +
          currentCheck + " check");
    }
    return prefixList;
  }

  /**
   * Buffered output of a data to a file. Prints entire line of formatted data
   *
   * @param output file location as a string
   * @param data   formatted data
   * @return BinaryTree containing the data
   */
  public static void bufferedWrite(String output, String data)
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
