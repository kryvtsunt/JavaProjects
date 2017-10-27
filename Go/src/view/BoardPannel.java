package view;

import model.IGoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


public class BoardPannel extends JPanel {
    IGoModel model;
    int pixelsHeight;
    int pixelsWidth;
    double gridSize;
    double offset;

    BoardPannel(IGoModel model, double gridSize) {
        super();
        this.model = model;
        this.pixelsWidth = this.getWidth();
        this.pixelsHeight = this.getHeight();
        this.gridSize = gridSize;
        this.offset = gridSize;
    }

    public void setModel(IGoModel model) {
        this.model = model;
    }

    public void setStones(Graphics2D canvas) {
        int[][] data = model.getData();
        int size = model.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (data[i][j] != 0) {
                    switch (data[i][j]) {
                        case 1:
                            canvas.setColor(Color.BLACK);
                            break;
                        case 2:
                            canvas.setColor(Color.white);
                            break;
                    }
                    Ellipse2D.Double c = new Ellipse2D.Double(offset + (gridSize * j) - gridSize / 3, offset + (gridSize * i) - gridSize / 3, gridSize / 1.5, gridSize / 1.5);
                    canvas.fill(c);
                }
            }
        }
    }

    private void makeBoard(Graphics2D canvas) {
        canvas.setColor(new Color(255,204,100));
        Rectangle2D.Double rect = new Rectangle2D.Double(offset / 2, offset / 2, gridSize * model.getSize(), gridSize * model.getSize());
        canvas.fill(rect);
        canvas.setColor(Color.black);
        canvas.setStroke(new BasicStroke(2));
        for (int i = 0; i < model.getSize(); i++) {
            Line2D.Double tmp = new Line2D.Double(offset + (gridSize * i), offset, offset + (gridSize * i), offset + (gridSize * 18));
            canvas.draw(tmp);
        }
        for (int i = 0; i < model.getSize(); i++) {
            Line2D.Double tmp = new Line2D.Double(offset, offset + (gridSize * i), offset + (gridSize * 18), offset + (gridSize * i));
            canvas.draw(tmp);
        }
        Ellipse2D.Double c1 = new Ellipse2D.Double(offset + (gridSize * 3) - gridSize / 8, offset + (gridSize * 3) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c1);
        Ellipse2D.Double c2 = new Ellipse2D.Double(offset + (gridSize * 9) - gridSize / 8, offset + (gridSize * 3) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c2);
        Ellipse2D.Double c3 = new Ellipse2D.Double(offset + (gridSize * 15) - gridSize / 8, offset + (gridSize * 3) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c3);
        Ellipse2D.Double c4 = new Ellipse2D.Double(offset + (gridSize * 3) - gridSize / 8, offset + (gridSize * 9) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c4);
        Ellipse2D.Double c5 = new Ellipse2D.Double(offset + (gridSize * 9) - gridSize / 8, offset + (gridSize * 9) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c5);
        Ellipse2D.Double c6 = new Ellipse2D.Double(offset + (gridSize * 15) - gridSize / 8, offset + (gridSize * 9) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c6);
        Ellipse2D.Double c7 = new Ellipse2D.Double(offset + (gridSize * 3) - gridSize / 8, offset + (gridSize * 15) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c7);
        Ellipse2D.Double c8 = new Ellipse2D.Double(offset + (gridSize * 9) - gridSize / 8, offset + (gridSize * 15) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c8);
        Ellipse2D.Double c9 = new Ellipse2D.Double(offset + (gridSize * 15) - gridSize / 8, offset + (gridSize * 15) - gridSize / 8, gridSize / 4, gridSize / 4);
        canvas.fill(c9);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g2);
        g2.setFont(new Font("panel", Font.BOLD, 10));
        makeBoard(g2);
        setStones(g2);
    }

    public Point getAt(int x, int y) {
        // If not black, get white key location
        for (int i = 0; i < model.getSize(); i++) {
            for (int j = 0; j < model.getSize(); j++) {
                double rectX = j * gridSize + offset / 2;
                double rectY = i * gridSize + offset / 2;
                if (x > rectX && x <= rectX + gridSize
                        && y > rectY && y <= rectY + gridSize) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}
