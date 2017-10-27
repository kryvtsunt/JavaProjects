package cs3500.hw04;

import static cs3500.hw04.FreecellModelCreator.GameType.MULTIMOVE;

import static org.junit.Assert.assertEquals;

import cs3500.hw02.Card;
import cs3500.hw02.FreeCellModelTest;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;
import java.util.List;
import org.junit.Test;

/**
 * a class to test the FreecellController.
 */
public class FreecellModel2Test extends FreeCellModelTest {

  @Override
  public FreecellOperations creator() {
    return FreecellModelCreator.create(MULTIMOVE);
  }

  FreecellOperations<Card> freecellModel = this.creator();

  /**
   * getTo method starts the game and gets a model to the certain state.
   */
  void getTo() {
    freecellModel.startGame(deck, 4, 24, false);

    freecellModel.move(PileType.CASCADE, 3, 12, PileType.OPEN,
        0);
    freecellModel.move(PileType.CASCADE, 3, 11, PileType.OPEN, 1);
    freecellModel.move(PileType.CASCADE, 3, 10, PileType.OPEN,
        2);
    freecellModel.move(PileType.CASCADE, 3, 9, PileType.FOUNDATION,
        3);
    freecellModel.move(PileType.FOUNDATION, 3, 0, PileType.OPEN, 3);
    freecellModel.move(PileType.OPEN, 3, 0, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.OPEN, 2, 0, PileType.OPEN, 3);
    freecellModel.move(PileType.FOUNDATION, 0, 0, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 3, 8, PileType.CASCADE, 1);
    freecellModel.move(PileType.CASCADE, 0, 12, PileType.OPEN, 5);
    freecellModel.move(PileType.CASCADE, 0, 11, PileType.OPEN, 6);
    freecellModel.move(PileType.CASCADE, 0, 10, PileType.OPEN, 7);
    freecellModel.move(PileType.CASCADE, 0, 9, PileType.OPEN, 8);
    freecellModel.move(PileType.CASCADE, 0, 8, PileType.OPEN, 9);
    freecellModel.move(PileType.CASCADE, 0, 7, PileType.OPEN, 10);
    freecellModel.move(PileType.CASCADE, 1, 12, PileType.CASCADE, 0);
    freecellModel.move(PileType.CASCADE, 3, 7, PileType.CASCADE, 1);
    freecellModel.move(PileType.CASCADE, 3, 6, PileType.OPEN, 11);
    freecellModel.move(PileType.CASCADE, 3, 5, PileType.OPEN, 12);
    freecellModel.move(PileType.CASCADE, 3, 4, PileType.OPEN, 13);
    freecellModel.move(PileType.CASCADE, 3, 3, PileType.OPEN, 14);
    freecellModel.move(PileType.CASCADE, 3, 2, PileType.OPEN, 15);
    freecellModel.move(PileType.CASCADE, 3, 1, PileType.OPEN, 16);
    freecellModel.move(PileType.CASCADE, 3, 0, PileType.OPEN, 17);
    freecellModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 3);
    freecellModel.move(PileType.CASCADE, 0, 6, PileType.CASCADE, 3);
    freecellModel.move(PileType.OPEN, 1, 0, PileType.CASCADE, 3);
    freecellModel.move(PileType.CASCADE, 0, 5, PileType.CASCADE, 3);
    freecellModel.move(PileType.CASCADE, 1, 11, PileType.CASCADE, 3);
    freecellModel.move(PileType.OPEN, 3, 0, PileType.CASCADE, 3);
    freecellModel.move(PileType.CASCADE, 0, 4, PileType.CASCADE, 3);
    freecellModel.move(PileType.CASCADE, 1, 10, PileType.CASCADE, 3);
    freecellModel.move(PileType.OPEN, 11, 0, PileType.CASCADE, 3);
    freecellModel.move(PileType.OPEN, 7, 0, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 0, 3, PileType.OPEN, 0);
    freecellModel.move(PileType.CASCADE, 0, 2, PileType.OPEN, 1);
    freecellModel.move(PileType.CASCADE, 0, 1, PileType.OPEN, 2);
    freecellModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 3, 0, PileType.CASCADE, 0);
    freecellModel.move(PileType.OPEN, 6, 0, PileType.CASCADE, 3);
  }

  List<Card> deck = freecellModel.getDeck();

  String output7 =
      "F1: A♣\n" +
          "F2: A♠, 2♠\n" +
          "F3:\n" +
          "F4:\n" +
          "O1: K♣\n" +
          "O2: 9♣\n" +
          "O3: 5♣\n" +
          "O4:\n" +
          "O5:\n" +
          "O6: 10♠\n" +
          "O7:\n" +
          "O8:\n" +
          "O9: J♥\n" +
          "O10: 7♥\n" +
          "O11: 3♥\n" +
          "O12:\n" +
          "O13: J♦\n" +
          "O14: 7♦\n" +
          "O15: 3♦\n" +
          "O16: Q♣\n" +
          "O17: 8♣\n" +
          "O18: 4♣\n" +
          "O19:\n" +
          "O20:\n" +
          "O21:\n" +
          "O22:\n" +
          "O23:\n" +
          "O24:\n" +
          "C1: K♠, Q♦, J♠, 10♥, 9♠, 8♦, 7♠, 6♥, 5♠, 4♦, 3♠, 2♥\n" +
          "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥\n" +
          "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n" +
          "C4: 6♠";


  @Test
  public void testValidlMove2() {
    getTo();
    assertEquals(output7, freecellModel.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves() {
    getTo();
    freecellModel.move(PileType.CASCADE, 2, 9, PileType.OPEN, 3);
    freecellModel.move(PileType.CASCADE, 2, 8, PileType.OPEN, 4);
    freecellModel.move(PileType.CASCADE, 2, 7, PileType.OPEN, 6);
    freecellModel.move(PileType.CASCADE, 2, 6, PileType.OPEN, 7);
    freecellModel.move(PileType.CASCADE, 2, 5, PileType.OPEN, 11);
    freecellModel.move(PileType.CASCADE, 2, 4, PileType.OPEN, 18);
    freecellModel.move(PileType.CASCADE, 2, 3, PileType.OPEN, 19);
    freecellModel.move(PileType.CASCADE, 2, 2, PileType.OPEN, 20);
    freecellModel.move(PileType.CASCADE, 2, 1, PileType.OPEN, 21);
    freecellModel.move(PileType.CASCADE, 2, 0, PileType.OPEN, 22);

    //invalid move. to few empty piles
    freecellModel.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves2() {
    freecellModel.startGame(deck, 4, 23, false);
    freecellModel.move(PileType.CASCADE, 3, 10, PileType.OPEN,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves3() {
    getTo();
    freecellModel.move(PileType.CASCADE, 0, 8, PileType.CASCADE, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves4() {
    getTo();
    freecellModel.move(PileType.CASCADE, 0, 8, PileType.OPEN, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoves5() {
    getTo();
    freecellModel.move(PileType.CASCADE, 1, 4, PileType.CASCADE, 3);
  }

}