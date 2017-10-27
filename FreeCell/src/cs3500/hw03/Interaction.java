package cs3500.hw03;

/**
 * Interaction interface is made to test the game.
 */
public interface Interaction {

  void apply(StringBuilder in, StringBuilder out);

  /**
   * Methtod prints(..) appends the array of strings to the output.
   *
   * @param lines [String...] an array of Strings
   * @return the appended output
   */
  static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line).append('\n');
      }
    };
  }

  /**
   * Method inputs(..) appends input string to the input.
   *
   * @param in [String] - fake input
   * @return the appended input
   */
  static Interaction inputs(String in) {
    return (input, output) -> {
      input.append(in);
    };
  }
}