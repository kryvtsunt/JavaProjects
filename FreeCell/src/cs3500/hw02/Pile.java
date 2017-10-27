package cs3500.hw02;

import java.util.ArrayList;

/**
 * Pile is an abstract class that represents a pile of cards.
 */
public abstract class Pile {

  /**
   * Cards is a field that represents cards in the pile.
   */
  private final ArrayList<Card> cards;

  /**
   * Constructor for Pile class takes no arguments.
   */
  protected Pile() {
    this.cards = new ArrayList<Card>();
  }

  /**
   * [void] Method validMove(Card card) takes a card and move it to the pile if the rules are
   * followed.
   */
  public void validMove(Card card) {
    if (isValidMove(card)) {
      getCards().add(card);
    } else {
      throw new IllegalArgumentException("Not accepted");
    }
  }

  /**
   * [boolean] isValidMove(Card card) method takes a card and returns true if the move is valid.
   */
  abstract public boolean isValidMove(Card card);

  /**
   * [void] addCard(Card card) method takes a card and adds it to the pile.
   */
  public void addCard(Card card) {
    cards.add(card);
  }

  /**
   * [String] toString() method takes no arguments and translates a pile into a string.
   */
  public String toString() {
    String output = "";
    for (int i = 0; i < cards.size(); i++) {
      if (i == cards.size() - 1) {
        output += " " + cards.get(cards.size() - 1).toString();
      } else {
        output += " " + cards.get(i).toString() + ",";
      }
    }
    return output;
  }

  /**
   * getCards() method takes no arguments and returns an arraylist of all cards in
   * the pile.
   */
  public ArrayList<Card> getCards() {
    return cards;
  }
}
