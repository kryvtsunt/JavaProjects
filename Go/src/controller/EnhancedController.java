package controller;

import model.IGoModel;
import view.IGoGUIView;
import view.IGoView;

import java.awt.*;
import java.awt.event.MouseEvent;


public class EnhancedController implements IGoController {

  private IGoModel model;
  private IGoGUIView view;


  public EnhancedController(IGoModel model, IGoGUIView view) {
    this.model = model;
    this.view = view;
    this.configureButtonListener();
  }


  private void configureButtonListener() {
    ButtonListener bl = new ButtonListener();
    System.out.println("Configuring Button Listener");
    bl.addPressedAction(MouseEvent.BUTTON1, new OnButton1Press());
    this.view.addMouseListener(bl);
  }

  @Override
  public void run() {
    this.view.setViewModel(model);
    System.out.print("NEW GAME \n");
    while (true) {
      if (model.win()) {
        System.out.print("Player " + ((model.getTurn() % 2) + 1) + " won\n");
        view.end();
        return;
      }
    }
  }

  class OnButton1Press implements Runnable2Args {

    @Override
    public void run(int x, int y) {
      Point a = view.getAt(x, y);
      try {
        model.addStone(a.x, a.y);
      }
      catch (IllegalArgumentException e){ System.out.print("Illegal move\n");}
      catch (NullPointerException e2) {System.out.print("Out of bound \n");}
        view.update();

    }
  }


//  class OnButton1Click implements Runnable2Args {
//
//    @Override
//    public void run(int x, int y) {
//      if (view.keyAtPosn(x, y)) {
//        AddNote an = view.getAddNote(x, y);
//        System.out.println("a");
//        model.addNote(new Note(an.getPitch(), 1), an.beat);
//        view.update();
//        beat++;
//        view.moveToBeat(beat);
//      }
//    }
//  }

}