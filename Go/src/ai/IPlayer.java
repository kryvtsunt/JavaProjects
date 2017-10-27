package ai;
import java.awt.Point;

import model.IGoModel;

public interface IPlayer {
  Point play(int color, IGoModel model);
}
