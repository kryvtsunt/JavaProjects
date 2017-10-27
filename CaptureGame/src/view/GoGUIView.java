package view;

import controller.ButtonListener;
import model.IGoModel;

import javax.swing.*;
import java.awt.*;


public class GoGUIView implements IGoGUIView {
    private IGoModel model;
    private int wPixels;
    private int hPixels;
    private int gridSize;
    private JFrame window;
    private BoardPannel board;

    public GoGUIView(IGoModel model) {

        this.model = model;
        this.window = new JFrame("Capture Game");
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //board.setPreferredSize(new Dimension(1000, 1000));
        //board.setAlignmentX(Component.CENTER_ALIGNMENT);
        window.setFocusable(true);
        window.requestFocusInWindow();
        gridSize = 50;
        window.setSize(new Dimension(gridSize*(model.getSize()+3), gridSize*(model.getSize()+3)));
        board = new BoardPannel(this.model, gridSize);
        this.wPixels = window.getWidth();
        this.hPixels = window.getHeight();
        window.setBackground(Color.black);
        window.add(board);
        window.setVisible(true);
    }

    @Override
    public void update() {
        model.getData();
        this.board.setModel(model);
        window.repaint();
    }

    @Override
    public void setViewModel(IGoModel model) {
        this.model = model;

    }

    @Override
    public void addMouseListener(ButtonListener bl) {
        this.board.addMouseListener(bl);

    }

    @Override
    public Point getAt(int x, int y) throws IllegalArgumentException {
        return this.board.getAt(x, y);
    }

    @Override
    public void end() {
        board.setEnabled(false);
    }
}
