package cs3500.hw03;

import static cs3500.hw03.Interaction.inputs;
import static cs3500.hw03.Interaction.prints;
import static cs3500.hw04.FreecellModelCreator.GameType.SINGLEMOVE;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellOperations;
import cs3500.hw04.FreecellModelCreator;
import java.io.StringReader;
import org.junit.Test;

/**
 * a class to test the FreecellController.
 */
public class FreecellControllerTest {

  protected String sourcePileSymbol = "(C|F|O|c|f|o)(\\d+)";
  protected String sourceIndexSymbol = "\\d+";
  protected String quitSymbol = "((.*)Q(.*)|(.*)q(.*))";

  public FreecellOperations creator() {
    return FreecellModelCreator.create(SINGLEMOVE);
  }

  FreecellOperations<Card> freecellModel = this.creator();

  /**
   * An example of interactions.
   */
  Interaction[] interactions = new Interaction[]{
      prints(
          "F1:\n" +
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
      inputs("C2 G F2\n"),
      prints("Invalid card index. "),
      prints(
          "F1:\n" +
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
      inputs("C1 2 2\n"),
      prints("Invalid destination pile. "),
      prints(
          "F1:\n" +
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
      inputs("C1 2 F2\n"),
      prints(
          "F1:\n" +
              "F2: A♥\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "C1: A♣\n" +
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
      inputs("G3 C F2\n"),
      prints("Invalid source pile. Invalid card index. "),
      prints(
          "F1:\n" +
              "F2: A♥\n" +
              "F3:\n" +
              "F4:\n" +
              "O1:\n" +
              "C1: A♣\n" +
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
      inputs("C23 2 O1\n"),
      prints(
          "F1:\n" +
              "F2: A♥\n" +
              "F3:\n" +
              "F4:\n" +
              "O1: 10♠\n" +
              "C1: A♣\n" +
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
              "C23: 10♦\n" +
              "C24: J♦, J♠\n" +
              "C25: Q♦, Q♠\n" +
              "C26: K♦, K♠\n" +
              "Input your move:"),
      prints("Invalid move. Try again. The destination pile does not accept your card"),
      inputs("O1 1 C6\n"),
      prints(
          "F1:\n" +
              "F2: A♥\n" +
              "F3:\n" +
              "F4:\n" +
              "O1: 10♠\n" +
              "C1: A♣\n" +
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
              "C23: 10♦\n" +
              "C24: J♦, J♠\n" +
              "C25: Q♦, Q♠\n" +
              "C26: K♦, K♠\n" +
              "Input your move:"),
      prints("Invalid move. Try again. Invalid arguments"),
      inputs("C1 2 F2\n"),
      prints(
          "F1:\n" +
              "F2: A♥\n" +
              "F3:\n" +
              "F4:\n" +
              "O1: 10♠\n" +
              "C1: A♣\n" +
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
              "C23: 10♦\n" +
              "C24: J♦, J♠\n" +
              "C25: Q♦, Q♠\n" +
              "C26: K♦, K♠\n" +
              "Input your move:"),
      inputs("wqe\n"),
      prints("Game quit prematurely.")
  };


  /**
   * Method Run(..) runs the game and compares the actual output with the expected one
   *
   * @param model - [FreecellModel]  model of the game
   * @param interactions - [Interactions[]] - imitation of the game inputs and outputs
   */
  protected void run1(FreecellOperations model, Interaction[] interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    IFreecellController controller = new FreecellController(input, actualOutput);
    controller.playGame(model.getDeck(), model, 26, 1, false);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  protected void run2(FreecellOperations model, Interaction[] interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    IFreecellController controller = new FreecellController(input, actualOutput);
    controller.playGame(null, null, 4, 1, true);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  protected void run3(FreecellOperations model, Interaction[] interactions) {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }

    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    IFreecellController controller = new FreecellController(input, actualOutput);
    controller.playGame(model.getDeck(), model, 1, 0, false);

    assertEquals("Could not start game.", actualOutput.toString());
  }

  @Test
  public void testValidGame() {
    assertTrue("fdskosQ".matches(quitSymbol));
    assertTrue("C1".matches(sourcePileSymbol));
    assertTrue("12".matches(sourceIndexSymbol));

    run1(freecellModel, this.interactions);
  }

  @Test
  public void testInvalidParameters() {
    assertFalse("".matches(sourceIndexSymbol));
    assertFalse("".matches(sourcePileSymbol));
    assertFalse("".matches(quitSymbol));
    assertFalse("12".matches(sourcePileSymbol));

    run3(freecellModel, this.interactions);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    run2(freecellModel, this.interactions);
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidController() {
    new FreecellController(null, null);
  }
}