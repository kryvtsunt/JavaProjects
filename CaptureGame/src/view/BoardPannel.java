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
    int gridSize;
    int offset;

    BoardPannel(IGoModel model, int gridSize) {
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
                    Ellipse2D.Double c = new Ellipse2D.Double(offset + (gridSize * j) - gridSize / 4, offset + (gridSize * i) - gridSize / 4, gridSize / 2, gridSize / 2);
                    canvas.fill(c);
                }
            }
        }
    }

    private void makeBoard(Graphics2D canvas) {
        canvas.setColor(Color.orange);
        Rectangle2D.Double rect = new Rectangle2D.Double(offset / 2, offset / 2, gridSize * model.getSize(), gridSize * model.getSize());
        canvas.fill(rect);
        canvas.setColor(Color.black);
        for (int i = 0; i < model.getSize(); i++) {
            Line2D.Double tmp = new Line2D.Double(offset + (gridSize * i), offset, offset + (gridSize * i), offset + (gridSize * 9));
            canvas.draw(tmp);
        }
        for (int i = 0; i < model.getSize(); i++) {
            Line2D.Double tmp = new Line2D.Double(offset, offset + (gridSize * i), offset + (gridSize * 9), offset + (gridSize * i));
            canvas.draw(tmp);
        }
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
                int rectX = j * gridSize + offset / 2;
                int rectY = i * gridSize + offset / 2;
                if (x > rectX && x <= rectX + gridSize
                        && y > rectY && y <= rectY + gridSize) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }
}
