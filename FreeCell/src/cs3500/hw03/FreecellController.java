package cs3500.hw03;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;


/**
 * FreecellController is a class that controls the Freecell game, processes the input and output.
 */
public class FreecellController implements IFreecellController<Card> {

  final Scanner in;
  final Appendable out;
  // indicates whether is required to stop the game
  private boolean quit = false;

  /**
   * constructor for the FreecellController.
   *
   * @param rd Readable
   * @param ap Appendable
   */

  public FreecellController(Readable rd, Appendable ap) {
    if (ap == null || rd == null) {
      throw new IllegalStateException();
    } else {
      this.in = new Scanner(rd);
      this.out = ap;
    }
  }

  @Override
  public void playGame(List<Card> deck, FreecellOperations<Card> model, int numCascades, int
      numOpens, boolean shuffle) {
    if ((deck == null) || (model == null)) {
      throw new IllegalArgumentException("Illegal arguments");
    }
    try {
      model.startGame(deck, numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException e) {
      appendString("Could not start game.");
      return;
    }
    while (!model.isGameOver()) {
      appendString(model.getGameState() + "\n" + "Input your move:\n");
      try {
        inputController(model);
      } catch (Exception error) {
        appendString(error.getMessage() + "\n");
      }
      if (quit) {
        appendString("Game quit prematurely.\n");
        return;
      }
    }
    appendString(model.getGameState() + "\n" + "Game over.\n");
  }

  /**
   * Method inputController(..) handles the user's input
   *
   * @param model [FreecellOperation] is a model of the game
   * @throws Exception when the error occur
   */
  protected void inputController(FreecellOperations model) throws Exception {
    String sourcePileSymbol = "(C|F|O|c|f|o)(\\d+)";
    String sourceIndexSymbol = "\\d+";
    String quitSymbol = "((.*)Q(.*)|(.*)q(.*))";
    String error = "";
    String sourcePile = null;
    String destPile = null;
    int sourcePileN = -1;
    int cardIndex = -1;
    int destPileN = -1;
    int i = 0;
    while (in.hasNext() && (i < 3)) {
      String input = in.next();
      if (input.matches(quitSymbol)) {
        quit = true;
        return;
      }
      switch (i) {
        case 0:
          if (input.matches(sourcePileSymbol)) {
            sourcePile = input.substring(0, 1).toUpperCase();
            sourcePileN = Integer.valueOf(input.substring(1)) - 1;
          } else {
            error += "Invalid source pile. ";
          }
          break;
        case 1:
          if (input.matches(sourceIndexSymbol)) {
            cardIndex = Integer.valueOf(input) - 1;
          } else {
            error += "Invalid card index. ";
          }
          break;
        case 2:
          if (input.matches(sourcePileSymbol)) {
            destPile = input.substring(0, 1).toUpperCase();
            destPileN = Integer.valueOf(input.substring(1)) - 1;
          } else {
            error += "Invalid destination pile. ";
            break;
          }
          if (sourcePile != null
              && cardIndex != -1
              && destPile != null) {
            try {
              model.move(whichPile(sourcePile), sourcePileN, cardIndex, whichPile(destPile),
                  destPileN);
            } catch (IllegalArgumentException e) {
              error += "Invalid move. Try again. " + e.getMessage();
              break;
            }
          }
          break;
        default:
          break;
      }
      i++;
    }
    if (!error.equals("")) {
      throw new Exception(error);
    }
  }

  /**
   * Method whichPile(..) tells which PileType is it by the given string
   *
   * @param pileString - [String] is a string that correspond to the certain PileType
   * @return [PileType] pile type that correspond to the given string
   */
  protected PileType whichPile(String pileString) {
    if (pileString.toUpperCase().equals("C")) {
      return PileType.CASCADE;
    }
    if (pileString.toUpperCase().equals("F")) {
      return PileType.FOUNDATION;
    }
    if (pileString.toUpperCase().equals("O")) {
      return PileType.OPEN;
    }
    throw new IllegalArgumentException();
  }

  /**
   * Method appendString(..) appends string to the output
   *
   * @param prompt [String] a string to append
   */
  protected void appendString(String prompt) {
    try {
      out.append(prompt);
    } catch (IOException e) {
      quit = true;
    }
  }
}




