package cs3500.hw02;

/**
 * CardValue represents an enumeration of card values.
 * CardValue is one of:
 * - ACE
 * - TWO
 * - THREE
 * - FOUR
 * - FIVE
 * - SIX
 * - SEVEN
 * - EIGHT
 * - NINE
 * - TEN
 * - JACK
 * - QUEEN
 * - KING.
 */
public enum CardValue {
  ACE("A"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");
  /**
   * value[String] a field that represents a value of the card.
   */
  private final String value;

  /**
   * CardValue(String value) - constructor for CardValue.
   */
  CardValue(String value) {
    this.value = value;
  }

  /**
   * toString() - method that takes nothing and returns a value of the card (String).
   */
  public String toString() {
    return value;
  }
}