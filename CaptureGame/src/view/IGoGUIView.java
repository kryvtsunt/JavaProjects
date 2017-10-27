package view;

import controller.ButtonListener;

import java.awt.*;


public interface IGoGUIView extends IGoView {
    void addMouseListener(ButtonListener bl);
    Point getAt(int x, int y) throws IllegalArgumentException;
    void end();
}
