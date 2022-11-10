import java.util.HashMap;

/*
 * file: Dictionary.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides a key value pairing object
 *
 * @author Justin Law
 * @version 1.0
 */

public class Dictionary {
  private HashMap<String, String> dictionary;

  /**
   * Constructor for dictionary with N elements
   *
   */
  public Dictionary(int n) {
    this.dictionary = new HashMap<>(n);
  }

   /**
   * Inserts a new element
   *
   * @param String key
   * @param String value
   * @return String
   *
   */
  public String insert(String key, String value) {
    this.dictionary.put(key, value);
    return String.format("%s - %s", key, value);
  }


   /**
   * Gets the value based on a key
   *
   * @param String key
   * @return String value
   *
   */
  public String get(String key) {
    return this.dictionary.get(key);
  }

  @Override
  public String toString() {
    return this.dictionary.toString();
  }
}
