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
import java.lang.NumberFormatException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReadWrite {

  /**
   * Buffered read of a properly formatted with data on each line. Meant to read
   * line-by-line performing a check on each string.
   *
   * @param input file location as a string
   * @return String containing all the data
   */
  public static String clearTextRead(String input) throws FileNotFoundException,
      IOException, InputMismatchException {
    String clearText = "";
    // try with resource, buffered file read on file at location
    try (BufferedReader bufferedInputData = new BufferedReader(
        new FileReader(new File(input)))) {
      // read line-by-line, until no strings are left in the file
      String s;
      while ((s = bufferedInputData.readLine()) != null) {
        for (int i = 0; i < s.length(); i++) {
          if (Character.isAlphabetic(s.charAt(i))) {
            clearText += s.charAt(i);
          }
        }
        clearText += "\n";
      }
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path invalid.");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data.");
    } catch (InputMismatchException e) {
      FormatError.printError(e, "A (String) character could not be parsed.");
    }
    return clearText.toUpperCase();
  }

  /**
   * Buffered read of a properly formatted with data on each line. Meant to read
   * line-by-line performing a check on each string.
   *
   * @param input file location as a string
   * @return String containing all the data
   */
  public static String codedTextRead(String input) throws FileNotFoundException,
      IOException, InputMismatchException, NumberFormatException {
    String codedText = "";
    // try with resource, buffered file read on file at location
    try (BufferedReader bufferedInputData = new BufferedReader(
        new FileReader(new File(input)))) {
      // read line-by-line, until no strings are left in the file
      String s;
      while ((s = bufferedInputData.readLine()) != null) {
        for (int i = 0; i < s.length(); i++) {
          if ((s.charAt(i) + "").equals("0") || (s.charAt(i) + "").equals("1")) {
            codedText += s.charAt(i);
          }
        }
        codedText += "\n";
      }
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path invalid.");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data.");
    } catch (InputMismatchException e) {
      FormatError.printError(e, "A (String) coded character could not be parsed.");
    } catch (NumberFormatException e) {
      FormatError.printError(e, "A (String) coded character could not be parsed.");
    }
    return codedText;
  }

  /**
   * Buffered read of a properly formatted with data on each line. Meant to read
   * line-by-line performing a check on each string.
   *
   * @param input file location as a string
   * @return Node[] containing the data
   */
  public static Node[] frequencyListRead(String input)
      throws FileNotFoundException, IOException, NumberFormatException,
      InputMismatchException, ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException {
    Node[] frequencyList = new Node[26];
    // try with resource, buffered file read on file at location
    try (BufferedReader bufferedInputData = new BufferedReader(
        new FileReader(new File(input)))) {
      // read line-by-line, until no strings are left in the file
      String s;
      int i = 0;
      while ((s = bufferedInputData.readLine()) != null) {
        String string = s.substring(0, 1);
        if (!Character.isLetter(string.charAt(0))) {
          throw new InputMismatchException();
        }
        int w = Integer.parseInt(s.substring(4));
        Node node = new Node(w, string);
        frequencyList[i] = node;
        i++;
      }
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path invalid.");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data.");
    } catch (StringIndexOutOfBoundsException e) {
      FormatError.printError(e, "Incorrectly formatted data.");
    } catch (NumberFormatException e) {
      FormatError.printError(e, "A (int) weight could not be parsed. Please check input file.");
    } catch (InputMismatchException e) {
      FormatError.printError(e, "A (String) character could not be parsed. Please check input file.");
    } catch (ArrayIndexOutOfBoundsException e) {
      FormatError.printError(e, "File contains more than the 26 characters in the english alphabet.");
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
    if ((new File(output)).exists()) {
      PrintWriter writer = new PrintWriter(output);
      writer.print("");
      writer.close();
    }
    // try with resource, buffered file output to file at location
    try (BufferedWriter bufferedOutputData = new BufferedWriter(
        new FileWriter(output, true))) {
      // empty file contents if file already exists
      // write new data
      bufferedOutputData.write(data);
      // catch block with tailored problem statements
    } catch (FileNotFoundException e) {
      FormatError.printError(e, "File or file path not invalid.");
    } catch (IOException e) {
      FormatError.printError(e, "Incorrectly formatted data.");
    }
    return;
  }

}
