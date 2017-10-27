package cs3500.hw04;

import cs3500.hw02.FreecellModel;
import cs3500.hw02.Card;
import cs3500.hw02.PileType;

/**
 * FreeCellModel2 represents multi-move model of the game.
 */
public class FreecellModel2 extends FreecellModel {

  @Override
  public void move(PileType sourceType, int sourcePileNumber, int cardIndex, PileType destType,
      int destPileNumber) throws IllegalArgumentException {

    if (!(anyViolations(sourceType, sourcePileNumber, cardIndex, destType, destPileNumber))
        && (validPile(sourcePileNumber, cardIndex)) && (enoughEmpty(sourcePileNumber, cardIndex))) {
      while (cardIndex < this.cascadePiles.get(sourcePileNumber).getCards().size()) {
        Card card = this.cascadePiles.get(sourcePileNumber).getCards().get(cardIndex);
        this.cascadePiles.get(destPileNumber).validMove(card);
        removeCard(sourceType, sourcePileNumber, cardIndex);
      }
    } else {
      super.move(sourceType, sourcePileNumber, cardIndex, destType, destPileNumber);
    }
  }

  /**
   * [boolean] anyViolations(PileType, int, int, PileType, int) method defines whether there are any
   * move violations.
   *
   * @param sourceType - type of the source
   * @param sourcePileNumber - number of the source pile
   * @param cardIndex - index of the source card
   * @param destType - type of the destination pile
   * @param destPileNumber - number of the destination pile.
   */
  private boolean anyViolations(PileType sourceType, int sourcePileNumber, int cardIndex, PileType
      destType, int destPileNumber) {
    return (sourcePileNumber < 0) ||
        (cardIndex < 0) ||
        (destPileNumber < 0) ||
        whichPile(sourceType).size() < sourcePileNumber ||
        whichPile(destType).size() < destPileNumber ||
        whichPile(sourceType).size() == 0 ||
        sourceType != PileType.CASCADE ||
        destType != PileType.CASCADE ||
        (cardIndex >= (this.cascadePiles.get(sourcePileNumber).getCards().size() - 1));
  }

  /**
   * method enoughEmpty determines if there is enough empty piles to make a move.
   *
   * @param sourcePileNumber [int]
   * @param cardIndex [int]
   * @return [boolean]
   */
  private boolean enoughEmpty(int sourcePileNumber, int cardIndex) {
    int sizeOfPile = this.cascadePiles.get(sourcePileNumber).getCards().size() - cardIndex;
    int n = 0;
    int m = 0;
    for (int i = 0; i < this.openPiles.size(); i++) {
      if (this.openPiles.get(i).getCards().size() == 0) {
        n++;
      }
    }
    for (int i = 0; i < this.cascadePiles.size(); i++) {
      if (this.cascadePiles.get(i).getCards().size() == 0) {
        m++;
      }
    }
    int k = (n + 1) * ((int) Math.pow(2, m));
    return (sizeOfPile <= k);
  }

  /**
   * method validPile determines if the pile is correctly ordered.
   *
   * @param sourcePileNumber [int]
   * @param cardIndex [int]
   * @return [boolean]
   */
  boolean validPile(int sourcePileNumber, int cardIndex) {
    int n = this.cascadePiles.get(sourcePileNumber).getCards().size();
    for (int i = cardIndex; i < n - 1; i++) {
      Card card = this.cascadePiles.get(sourcePileNumber).getCards().get(i);
      Card card0 = this.cascadePiles.get(sourcePileNumber).getCards().get(i + 1);
      if ((!(card0.oneLess(card))) && (card0.getColor() != card.getColor())) {
        return false;
      }
    }
    return true;
  }
}