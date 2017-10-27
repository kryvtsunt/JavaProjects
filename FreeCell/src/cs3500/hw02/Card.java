package cs3500.hw02;

/**
 * Card is a class that represents a card.
 */
public class Card {

  /**
   * the field suit[SuitType] represents a card suit
   * the field value[CardValue] represents a card value
   * the field color[SuitColor[ represents a card color.
   */

  private final SuitType suit;
  private final CardValue value;
  private final SuitColor color;

  /**
   * Constructor for the Card.
   * @param suit  - suit of the card
   * @param value - card value
   */
  public Card(SuitType suit, CardValue value) {
    this.suit = suit;
    this.value = value;
    this.color = suit.defineColor();
  }


  /**
   * Method toString() converts a Card into String.
   * @return [String] a representation of the card in string
   */
  public String toString() {
    return this.value.toString() + this.suit.toString();
  }


  /**
   *  Method CardValue() gets the value of the Card.
   * @return [CardValue] value of the card
   */
  public CardValue getValue() {
    return this.value;
  }

  /**
   * Method SuitType() gets the type of the Suit.
   * @return [SuitType] suit of the card
   */
  public SuitType getSuit() {
    return this.suit;
  }


  /**
   * Method getColor() gets a color of the Card.
   * @return [SuitColor] color of the suit/card
   */
  public SuitColor getColor() {
    return this.color;
  }

  /**
   * Method isMoveble(Card card) tells if the card is movable.
   * @param card - a Card
   * @return [boolean] true if the card is movable
   */
  public boolean isMovable(Card card) {
    return ((this.getColor() != card.getColor()) &&
        this.oneLess(card));
  }

  /**
   * Method oneLess(Card that) tells if the card's value is one less than the given card.
   * @param that - card to compare
   * @return [boolean] true if the card is one less than the given card
   */
  public boolean oneLess(Card that) {
    return ((this.getValue() == CardValue.ACE && that.getValue() == CardValue.TWO) ||
        (this.getValue() == CardValue.TWO && that.getValue() == CardValue.THREE) ||
        (this.getValue() == CardValue.THREE && that.getValue() == CardValue.FOUR) ||
        (this.getValue() == CardValue.FOUR && that.getValue() == CardValue.FIVE) ||
        (this.getValue() == CardValue.FIVE && that.getValue() == CardValue.SIX) ||
        (this.getValue() == CardValue.SIX && that.getValue() == CardValue.SEVEN) ||
        (this.getValue() == CardValue.SEVEN && that.getValue() == CardValue.EIGHT) ||
        (this.getValue() == CardValue.EIGHT && that.getValue() == CardValue.NINE) ||
        (this.getValue() == CardValue.NINE && that.getValue() == CardValue.TEN) ||
        (this.getValue() == CardValue.TEN && that.getValue() == CardValue.JACK) ||
        (this.getValue() == CardValue.JACK && that.getValue() == CardValue.QUEEN) ||
        (this.getValue() == CardValue.QUEEN && that.getValue() == CardValue.KING));
  }
}

