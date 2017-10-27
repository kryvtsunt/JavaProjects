package cs3500.hw04;


import cs3500.hw02.FreecellModel;
import cs3500.hw02.FreecellOperations;


/**
 * Represents the FreecellOperations factory.
 */
public class FreecellModelCreator {

  public enum GameType {
    SINGLEMOVE, MULTIMOVE
  }

  /**
   * create method creates an object of the FreecellOperations type.
   *
   * @param game enum
   * @return FreecellOperations
   */
  static public FreecellOperations create(GameType game) {
    if (game == GameType.SINGLEMOVE) {
      return new FreecellModel();
    } else {
      return new FreecellModel2();
    }
  }
}