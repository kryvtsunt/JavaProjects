package controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;


public class ButtonListener implements MouseListener {

  Map<Integer, Runnable2Args> clicked;
  Map<Integer, Runnable2Args> pressed;
  Map<Integer, Runnable2Args> released;


  public ButtonListener() {
    clicked = new HashMap<Integer, Runnable2Args>();
    pressed = new HashMap<Integer, Runnable2Args>();
    released = new HashMap<Integer, Runnable2Args>();
  }


  @Override
  public void mouseClicked(MouseEvent e) {
    if (clicked.containsKey(e.getButton())) {
      clicked.get(e.getButton()).run(e.getX(), e.getY());
    }
  }


  public void addClickedAction(int button, Runnable2Args act) {
    this.clicked.put(button, act);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (pressed.containsKey(e.getButton())) {
      pressed.get(e.getButton()).run(e.getX(), e.getY());
    }
  }

  public void addPressedAction(int button, Runnable2Args act) {
    this.pressed.put(button, act);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (released.containsKey(e.getButton())) {
      released.get(e.getButton()).run(e.getX(), e.getY());
    }
  }

  public void addReleasedAction(int button, Runnable2Args act) {
    this.released.put(button, act);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // null
  }

  @Override
  public void mouseExited(MouseEvent e) {
    //null
  }
}
