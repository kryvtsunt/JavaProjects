package cs3500.hw03;

import cs3500.hw02.FreecellOperations;
import java.util.List;

/**
 * An interface that represents a game controller.
 *
 * @param <K> - a parameter to deal with ( in this game K is Card)
 */
public interface IFreecellController<K> {

  /**
   * Method playGame(..) starts the game by the given parameters.
   *
   * @param deck - [List] a deck of cards
   * @param model - [FreecellOperations] a model of the Freecell game
   * @param numCascades - [int] number of cascade piles
   * @param numOpens - [int] number of open piles
   * @param shuffle - [boolean] true if it is required to shuffle the deck
   */
  void playGame(List<K> deck, FreecellOperations<K> model, int numCascades, int numOpens, boolean
      shuffle);
}
