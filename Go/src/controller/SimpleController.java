package controller;

import model.IGoModel;
import view.IGoView;

import java.awt.*;
import java.util.Scanner;


public class SimpleController implements IGoController {
    private IGoModel model;
    private IGoView view;

    public SimpleController(IGoModel model, IGoView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.view.setViewModel(model);
        System.out.print("NEW GAME \n");
        while (true) {
            System.out.print("Turn of player " + ((model.getTurn() % 2) + 1) + '\n');
            System.out.print("Where do you want to place your stone:");
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            try {
                model.addStone(c1, c2);
            }
            catch (IllegalArgumentException e){ System.out.print("You are not allowed to do it\n"); continue; }
            catch (ArrayIndexOutOfBoundsException e2) {System.out.print("Out of bound \n"); continue; }
            System.out.print("You've made your turn\n");
            this.view.update();
            if (model.win()) {
                System.out.print("Player" + ((model.getTurn()%2)+1)+ "won");
                break;
            }
        }
    }
}

