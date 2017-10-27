package view;

import controller.ButtonListener;
import model.IGoModel;

import javax.swing.*;
import java.awt.*;


public class GoGUIView implements IGoGUIView {
    private IGoModel model;
    private double gridSize;
    private JFrame window;
    private BoardPannel board;
    private Panel end;

    public GoGUIView(IGoModel model) {

        this.model = model;
        this.window = new JFrame("Capture Game");
        window.setResizable(false);
        //window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setFocusable(true);
        window.requestFocusInWindow();
        gridSize = 40;
        //window.setSize(new Dimension((int)gridSize*(model.getSize()+2), (int)gridSize*(model.getSize()+2)));
        board = new BoardPannel(this.model, gridSize);
        end = new Panel();
        end.add(new JLabel("End of the game"));
        end.setPreferredSize(new Dimension((int)gridSize*(model.getSize()+1), (int)gridSize*(model.getSize()+1)));
        window.setBackground(Color.black);
        board.setPreferredSize(new Dimension((int)gridSize*(model.getSize()+1), (int)gridSize*(model.getSize()+1)));
        window.add(board);
        window.setVisible(true);
        window.pack();
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
        JOptionPane.showMessageDialog(window,"Player " + ((model.getTurn() % 2) + 1) + " won","End of the game", JOptionPane.INFORMATION_MESSAGE);
        window.dispose();
    }
}
