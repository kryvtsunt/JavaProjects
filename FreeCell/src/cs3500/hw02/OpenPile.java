package cs3500.hw02;

/**
 * Represents an open pile.
 */
public class OpenPile extends Pile {

  @Override
  public boolean isValidMove(Card card) {
    return (this.getCards().size() == 0);
  }
}