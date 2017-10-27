package cs3500.hw04;

import static cs3500.hw03.Interaction.inputs;
import static cs3500.hw03.Interaction.prints;
import static cs3500.hw04.FreecellModelCreator.GameType.MULTIMOVE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellOperations;
import cs3500.hw03.FreecellControllerTest;
import cs3500.hw03.Interaction;
import org.junit.Test;

/**
 * class to test FreecellController on model2.
 */
public class FreecellController2Test extends FreecellControllerTest {

  @Override
  public FreecellOperations creator() {
    return FreecellModelCreator.create(MULTIMOVE);
  }

  FreecellOperations<Card> freecellModel = this.creator();

  Interaction[] interactions2 = new Interaction[]{
      prints("F1:\n" +
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
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("C10 2 C24\n"),
      prints("F1:\n" +
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
          "C10: 10♣\n" +
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
          "C24: J♦, J♠, 10♥\n" +
          "C25: Q♦, Q♠\n" +
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("C24 2 C12\n"),
      prints("F1:\n" +
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
          "C10: 10♣\n" +
          "C11: J♣, J♥\n" +
          "C12: Q♣, Q♥, J♠, 10♥\n" +
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
          "C24: J♦\n" +
          "C25: Q♦, Q♠\n" +
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("q"),
      prints("Game quit prematurely.")
  };

  Interaction[] interactions3 = new Interaction[]{
      prints("F1:\n" +
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
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("C10 2 C24\n"),
      prints("F1:\n" +
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
          "C10: 10♣\n" +
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
          "C24: J♦, J♠, 10♥\n" +
          "C25: Q♦, Q♠\n" +
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("C24 2 C12\n"),
      prints("F1:\n" +
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
          "C10: 10♣\n" +
          "C11: J♣, J♥\n" +
          "C12: Q♣, Q♥, J♠, 10♥\n" +
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
          "C24: J♦\n" +
          "C25: Q♦, Q♠\n" +
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("C12 2 C26\n"),
      prints("Invalid move. Try again. Invalid arguments"),
      prints("F1:\n" +
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
          "C10: 10♣\n" +
          "C11: J♣, J♥\n" +
          "C12: Q♣, Q♥, J♠, 10♥\n" +
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
          "C24: J♦\n" +
          "C25: Q♦, Q♠\n" +
          "C26: K♦, K♠\n" +
          "Input your move:"),
      inputs("df WQE fd"),
      prints("Game quit prematurely.")
  };

  @Test
  public void testValidGame2() {
    assertTrue("fdsk osQ".matches(quitSymbol));
    assertTrue("C1".matches(sourcePileSymbol));
    assertTrue("12".matches(sourceIndexSymbol));

    run1(freecellModel, this.interactions2);
  }

  @Test
  public void testInvalidMoves() {
    assertFalse("fdskos".matches(quitSymbol));
    assertFalse("G1".matches(sourcePileSymbol));
    assertFalse("15G".matches(sourceIndexSymbol));

    run1(freecellModel, this.interactions3);
  }



}
