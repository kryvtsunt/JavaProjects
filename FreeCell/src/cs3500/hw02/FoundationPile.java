package cs3500.hw02;

/**
 * Represents a foundation pile.
 */
public class FoundationPile extends Pile {

  @Override
  public boolean isValidMove(Card card) {
    int last = getCards().size() - 1;
    return (((card.getValue() == CardValue.ACE && getCards().size() == 0))
        || ((getCards().size() != 0) && (card.getSuit() == getCards().get(0).getSuit()) &&
        getCards().get(last).oneLess(card)));
  }
}
