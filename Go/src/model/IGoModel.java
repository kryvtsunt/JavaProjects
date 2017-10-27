package model;

import java.awt.*;


public interface IGoModel {

    public void addStone(int x, int y) throws IllegalArgumentException;

    public int[][] getData();

    public int getTurn();

    public boolean win();

    public int getSize();
}
