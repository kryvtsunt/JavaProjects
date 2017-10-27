package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class FreeCellModel implements FreecellOperations interface.
 * it has 3 fields:
 * - cascadePiles[ArrayList] is a field that represents all cascade piles
 * - foundationPiles[ArrayList] is a field that represents all foundation piles
 * - openPiles[ArrayList] is a field that represents all open piles.
 */
public class FreecellModel implements FreecellOperations<Card> {

  protected ArrayList<CascadePile> cascadePiles;
  protected ArrayList<FoundationPile> foundationPiles;
  protected ArrayList<OpenPile> openPiles;

  /**
   * The constructor for FreeCellModel takes no arguments.
   */
  public FreecellModel() {
    cascadePiles = new ArrayList<CascadePile>();
    foundationPiles = new ArrayList<FoundationPile>(4);
    openPiles = new ArrayList<OpenPile>();
  }

  /**
   * [void] The setFreeCellModel(int, int) takes the number of cascade piles and the number of open
   * piles and creates these piles.
   */
  private void setFreeCellModel(int numCascadePiles, int numOpenPiles) {
    for (int i = 0; i < numCascadePiles; i++) {
      cascadePiles.add(new CascadePile());
    }
    for (int i = 0; i < numOpenPiles; i++) {
      openPiles.add(new OpenPile());
    }
    for (int i = 0; i < 4; i++) {
      foundationPiles.add(new FoundationPile());
    }
  }

  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<Card>();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {
        deck.add(new Card(SuitType.values()[i], CardValue.values()[j]));
      }
    }
    return deck;
  }

  @Override
  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle)
      throws IllegalArgumentException {
    if (invalidStart(deck, numCascadePiles, numOpenPiles)) {
      throw new IllegalArgumentException("Invalid arguments");
    }
    reset();
    if (shuffle) {
      Collections.shuffle(deck);
    }
    setFreeCellModel(numCascadePiles, numOpenPiles);
    for (int i = 0; i < deck.size(); i++) {
      cascadePiles.get(i % numCascadePiles).addCard(deck.get(i));
    }
  }

  @Override
  public String getGameState() {
    String output = "";
    int cascadeSize = cascadePiles.size();
    int foundationSize = foundationPiles.size();
    int openSize = openPiles.size();
    for (int i = 0; i < foundationSize; i++) {
      output += "F" + (i + 1) + ":" + foundationPiles.get(i).toString() + "\n";
    }
    for (int i = 0; i < openSize; i++) {
      output += "O" + (i + 1) + ":" + openPiles.get(i).toString() + "\n";
    }
    for (int i = 0; i < cascadeSize; i++) {
      if (i == cascadeSize - 1) {
        output += "C" + (i + 1)
            + ":" + cascadePiles.get(i).toString();
      } else {
        output += "C" + (i + 1)
            + ":" + cascadePiles.get(i).toString() + "\n";
      }
    }
    return output;

  }

  @Override
  public void move(PileType sourceType, int sourcePileNumber, int cardIndex, PileType destType,
      int destPileNumber) throws IllegalArgumentException {
    if (anyViolations(sourceType, sourcePileNumber, cardIndex, destType, destPileNumber)) {
      throw new IllegalArgumentException("Invalid arguments");
    }
    if (((sourceType == destType) && (sourcePileNumber == destPileNumber))) {
      throw new IllegalArgumentException("You are trying to move card to the same place");
    }
    Card card = ((ArrayList<Pile>) whichPile(sourceType)).get(sourcePileNumber).getCards()
        .get(cardIndex);
    try {
      ((ArrayList<Pile>) whichPile(destType)).get(destPileNumber).validMove(card);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("The destination pile does not accept your card");
    }
    removeCard(sourceType, sourcePileNumber, cardIndex);
  }

  @Override
  public boolean isGameOver() {
    return foundationPiles.get(0).getCards().size() == 13 &&
        foundationPiles.get(1).getCards().size() == 13 &&
        foundationPiles.get(2).getCards().size() == 13 &&
        foundationPiles.get(3).getCards().size() == 13;
  }

  /**
   * [ArrayList<?> whichPile(PileType) a method that takes a type of the pile and directs you to
   * that pile.
   */
  protected ArrayList<?> whichPile(PileType sourceType) {
    ArrayList<?> output = new ArrayList<>();
    switch (sourceType) {
      case CASCADE:
        output = this.cascadePiles;
        break;
      case OPEN:
        output = this.openPiles;
        break;
      case FOUNDATION:
        output = this.foundationPiles;
        break;
      default:
    }
    return output;
  }

  /**
   * [boolean] invalidDeck(List) method defines whether the deck is valid.
   *
   * @param deck - a deck of cards.
   */
  private boolean invalidDeck(List<Card> deck) {
    Set<Card> deckSet = new HashSet<>();
    for (int i = 0; i < deck.size(); i++) {
      deckSet.add(deck.get(i));
    }
    return !((deckSet.size() == 52) && (deck.size() == 52));
  }

  /**
   * [boolean] invalidStart(List, int, int) method defines whether the game Start is invalid.
   *
   * @param deck - a deck of cards
   * @param numCascadePiles - number of cascade piles
   * @param numOpenPiles - number of open piles.
   */
  private boolean invalidStart(List<Card> deck, int numCascadePiles, int numOpenPiles) {
    return invalidDeck(deck) || (numCascadePiles < 4) || (numOpenPiles < 1);
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
        (cardIndex != (
            ((ArrayList<Pile>) whichPile(sourceType)).get(sourcePileNumber).getCards().size() - 1))
        ||
        whichPile(sourceType).size() == 0;
  }

  /**
   * [void] removeCard(PileType, int, int) method that removes a card from the pile.
   *
   * @param sourceType - type of the pile
   * @param sourcePileNumber - number of the pile
   * @param cardIndex - index of the card to remove.
   */
  protected void removeCard(PileType sourceType, int sourcePileNumber, int cardIndex) {
    ((ArrayList<Pile>) this.whichPile(sourceType)).get(sourcePileNumber).getCards()
        .remove(cardIndex);
  }

  /**
   * [void] reset() method takes no arguments. Resets the game.
   */
  private void reset() {
    cascadePiles.clear();
    openPiles.clear();
    foundationPiles.clear();
  }
}
