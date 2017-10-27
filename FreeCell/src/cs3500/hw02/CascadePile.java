package cs3500.hw02;

/**
 * Represents a cascade pile.
 */
public class CascadePile extends Pile {

  @Override
  public boolean isValidMove(Card card) {
    int lastCard = getCards().size() - 1;
    return ((getCards().size() == 0) ||
        (((card.getColor()) != getCards().get(lastCard).getColor()) &&
            (card.oneLess(getCards().get(lastCard)))));
  }
}
