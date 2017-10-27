package cs3500.hw02;


import static cs3500.hw04.FreecellModelCreator.GameType.SINGLEMOVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.hw04.FreecellModelCreator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Class that tests the FreeCellModel.
 */
public class FreeCellModelTest {

  /**
   * creator method creates an object of the FreecellOperations type.
   * @return[FreecellOpertions]
   */
  public FreecellOperations creator() {
    return FreecellModelCreator.create(SINGLEMOVE);
  }

  FreecellOperations<Card> freecellModel = this.creator();

  Card card0 = new Card(SuitType.DIAMONDS, CardValue.JACK);
  Card card1 = new Card(SuitType.SPADES, CardValue.EIGHT);
  Card card2 = new Card(SuitType.DIAMONDS, CardValue.ACE);
  Card card3 = new Card(SuitType.CLUBS, CardValue.QUEEN);


  List<Card> deck = freecellModel.getDeck();
  String deckString = "[A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣, "
      + "A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, "
      + "A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥,"
      + " A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠]";

  String output =
      "F1:\n" +
          "F2:\n" +
          "F3:\n" +
          "F4:\n" +
          "O1:\n" +
          "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n" +
          "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠\n" +
          "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n" +
          "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠";

  String output2 =
      "F1:\n" +
          "F2:\n" +
          "F3:\n" +
          "F4:\n" +
          "O1: J♠\n" +
          "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n" +
          "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠\n" +
          "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n" +
          "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠";


  String output3 =
      "F1:\n" +
          "F2: A♠\n" +
          "F3:\n" +
          "F4:\n" +
          "O1: K♠\n" +
          "O2: 9♠\n" +
          "O3:\n" +
          "O4: 5♠\n" +
          "C1: A♣, 5♣, 9♣, K♣, 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠\n" +
          "C2: 2♣, 6♣, 10♣, A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 10♥\n" +
          "C3: 3♣, 7♣, J♣, 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠\n" +
          "C4: 4♣, 8♣, Q♣, 3♦, 7♦, J♦, 2♥, 6♥";

  String output4 =
      "F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
          "F2: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
          "F3: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
          "F4: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
          "O1:\n" +
          "C1:\n" +
          "C2:\n" +
          "C3:\n" +
          "C4:\n" +
          "C5:\n" +
          "C6:\n" +
          "C7:\n" +
          "C8:\n" +
          "C9:\n" +
          "C10:\n" +
          "C11:\n" +
          "C12:\n" +
          "C13:\n" +
          "C14:\n" +
          "C15:\n" +
          "C16:\n" +
          "C17:\n" +
          "C18:\n" +
          "C19:\n" +
          "C20:\n" +
          "C21:\n" +
          "C22:\n" +
          "C23:\n" +
          "C24:\n" +
          "C25:\n" +
          "C26:";


  String output5 = "F1:\n" +
      "F2:\n" +
      "F3:\n" +
      "F4:\n" +
      "O1:\n" +
      "O2:\n" +
      "C1: A♣, 7♣, K♣, 6♦, Q♦, 5♥, J♥, 4♠, 10♠\n" +
      "C2: 2♣, 8♣, A♦, 7♦, K♦, 6♥, Q♥, 5♠, J♠\n" +
      "C3: 3♣, 9♣, 2♦, 8♦, A♥, 7♥, K♥, 6♠, Q♠\n" +
      "C4: 4♣, 10♣, 3♦, 9♦, 2♥, 8♥, A♠, 7♠, K♠\n" +
      "C5: 5♣, J♣, 4♦, 10♦, 3♥, 9♥, 2♠, 8♠\n" +
      "C6: 6♣, Q♣, 5♦, J♦, 4♥, 10♥, 3♠, 9♠";

  String output6 = "F1:\n" +
      "F2:\n" +
      "F3:\n" +
      "F4:\n" +
      "O1:\n" +
      "C1: A♣, A♥\n" +
      "C2: 2♣, 2♥\n" +
      "C3: 3♣, 3♥\n" +
      "C4: 4♣, 4♥\n" +
      "C5: 5♣, 5♥\n" +
      "C6: 6♣, 6♥\n" +
      "C7: 7♣, 7♥\n" +
      "C8: 8♣, 8♥\n" +
      "C9: 9♣, 9♥\n" +
      "C10: 10♣, 10♥\n" +
      "C11: J♣, J♥\n" +
      "C12: Q♣, Q♥\n" +
      "C13: K♣, K♥\n" +
      "C14: A♦, A♠\n" +
      "C15: 2♦, 2♠\n" +
      "C16: 3♦, 3♠\n" +
      "C17: 4♦, 4♠\n" +
      "C18: 5♦, 5♠\n" +
      "C19: 6♦, 6♠\n" +
      "C20: 7♦, 7♠\n" +
      "C21: 8♦, 8♠\n" +
      "C22: 9♦, 9♠\n" +
      "C23: 10♦, 10♠\n" +
      "C24: J♦, J♠\n" +
      "C25: Q♦, Q♠\n" +
      "C26: K♦, K♠";


  @Test
  public void testCardMethods() {
    assertFalse(card0.oneLess(card1));
    assertFalse(card1.oneLess(card2));
    assertFalse(card0.oneLess(card2));
    assertFalse(card0.oneLess(card0));
    assertTrue(card0.oneLess(card3));
    assertTrue(card0.isMovable(card3));
    assertFalse(card0.isMovable(card0));
    assertFalse(card3.isMovable(card0));
    assertEquals(SuitColor.RED, card0.getColor());
    assertEquals(SuitColor.BLACK, card3.getColor());
    assertEquals("J♦", card0.toString());
    assertEquals("8♠", card1.toString());
  }


  @Test
  public void testGetGameState() {

    assertEquals("", freecellModel.getGameState());

    freecellModel.startGame(deck, 4, 1, false);
    assertEquals(output, freecellModel.getGameState());

    freecellModel.startGame(deck, 6, 2, false);
    assertEquals(output5, freecellModel.getGameState());

  }

  @Test
  public void testValidlMove() {

    freecellModel.startGame(deck, 4, 4, false);

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
    assertEquals(output3, freecellModel.getGameState());

    freecellModel.startGame(deck, 4, 1, false);

    assertEquals(output, freecellModel.getGameState());

    freecellModel.move(PileType.CASCADE, 1, 12, PileType.OPEN,
        0);
    assertEquals(output2, freecellModel.getGameState());

    freecellModel.startGame(deck, 4, 1, true);
  }

  @Test
  public void testIsGameOver() {
    freecellModel.startGame(deck, 4, 1, true);
    assertEquals(false, freecellModel.isGameOver());
  }


  @Test
  public void testGetDeck() {
    assertEquals(deckString, deck.toString());
    assertEquals(52, freecellModel.getDeck().size());
  }


  @Test
  public void testGetToTheEndOfTheGame() {
    freecellModel.startGame(deck, 26, 1, false);
    assertEquals(false, freecellModel.isGameOver());
    assertEquals(output6, freecellModel.getGameState());

    freecellModel.move(PileType.CASCADE, 0, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 1, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 2, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 3, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 4, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 5, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 6, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 7, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 8, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 9, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 10, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 11, 1, PileType.FOUNDATION, 0);
    freecellModel.move(PileType.CASCADE, 12, 1, PileType.FOUNDATION, 0);

    freecellModel.move(PileType.CASCADE, 13, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 14, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 15, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 16, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 17, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 18, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 19, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 20, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 21, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 22, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 23, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 24, 1, PileType.FOUNDATION, 1);
    freecellModel.move(PileType.CASCADE, 25, 1, PileType.FOUNDATION, 1);

    freecellModel.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION, 2);
    freecellModel.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION, 2);

    freecellModel.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION, 3);
    freecellModel.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION, 3);

    assertEquals(true, freecellModel.isGameOver());
    assertEquals(output4, freecellModel.getGameState());

    freecellModel.startGame(deck, 4, 1, false);
    assertEquals(false, freecellModel.isGameOver());
    assertEquals(output, freecellModel.getGameState());
  }


  //Exceptions
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartGameArguments0() {
    freecellModel.startGame(deck, 3, 4, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStartGameArguments1() {
    freecellModel.startGame(deck, 4, 0, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDeck() {
    ArrayList<Card> deck = new ArrayList<>();
    for (int i = 0; i < 52; i++) {
      deck.add(card1);
    }
    freecellModel.startGame(deck, 4, 1, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove0() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.OPEN, 6, 0, PileType.OPEN, 0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, -1, 6, PileType.OPEN,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 6, -3, PileType.OPEN,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 1, 6, PileType.OPEN,
        -5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    freecellModel.startGame(deck, 4, 2, false);
    freecellModel.move(PileType.OPEN, 0, 15, PileType.OPEN,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE,
        1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove6() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 1, 6, PileType.CASCADE,
        2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove7() {
    freecellModel.startGame(deck, 4, 4, false);
    freecellModel.move(PileType.CASCADE, 0, 12, PileType.FOUNDATION,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove8() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 0, 6, PileType.OPEN,
        0);
    freecellModel.move(PileType.CASCADE, 0, 5, PileType.OPEN, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove9() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 0, 6, PileType.OPEN,
        0);
    freecellModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove10() {
    freecellModel.startGame(deck, 8, 4, false);
    freecellModel.move(PileType.CASCADE, 0, 6, PileType.OPEN,
        0);
    freecellModel.move(PileType.OPEN, 0, 0, PileType.CASCADE, 9);

  }

}