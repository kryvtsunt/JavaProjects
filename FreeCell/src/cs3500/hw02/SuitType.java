package cs3500.hw02;

/**
 * SuitType is an enumeration of the suit types of the card.
 * SuitType is one of:
 * - CLUBS
 * - DIAMONDS
 * - HEARTS
 * - SPADES.
 */

public enum SuitType {
  CLUBS("♣"),
  DIAMONDS("♦"),
  HEARTS("♥"),
  SPADES("♠");


  /**
   * suit [String] a field that represents a suit.
   * color [SuitColor] a field that represents a color.
   */
  private final String suit;

  /**
   * Constuctor of the SuitType.
   */
  SuitType(String suit) {
    this.suit = suit;
  }

  /**
   * toString() - a function that takes nothing and returns a suit of the card(String).
   */
  public String toString() {
    return suit;
  }

  /**
   * defineColor() - a method that takes nothing and returns a color of the suit (SuitColor).
   */
  public final SuitColor defineColor() {
    if (this.suit.equals("♥") || this.suit.equals("♦")) {
      return SuitColor.RED;
    } else {
      return SuitColor.BLACK;
    }
  }
}







