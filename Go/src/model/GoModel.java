package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;


public class GoModel implements IGoModel{
    private int[][] board;
    private int turn;
    private int SIZE;
    private final int NONE = 0;
    private final int BLACK = 1;
    private final int WHITE = 2;

    public GoModel() {
        SIZE = 19;
        board = new int[SIZE][SIZE];
        turn = 0;
    }

    private int oppositeColor(int color) {
        if (color == BLACK) {
            return WHITE;
        } else {
            return BLACK;
        }
    }

    private int getCurrentColor() {
        return (turn % 2)+ 1;
    }


    private ArrayList<Point> searchConnected(int x, int y, int color, boolean[][] visited) {
        ArrayList<Point> result = new ArrayList<>();
        visited[x][y] = true;
        if (color == board[x][y]) {
            result.add(new Point(x, y));
            if ((y > 0) && !visited[x][y - 1]) {
                result.addAll(searchConnected(x, y-1, color, visited));
            }
            if ((y < SIZE-1) && !visited[x][y + 1]) {
                result.addAll(searchConnected(x, y+1, color, visited));
            }
            if ((x > 0) && !visited[x-1][y]) {
                result.addAll(searchConnected(x-1, y, color, visited));
            }
            if ((x < SIZE-1) && !visited[x+1][y]) {
                result.addAll(searchConnected(x+1, y, color, visited));
            }
        }
        return result;
    }

    private boolean isSurrounded(int color, ArrayList<Point> connected) {
        for (Point p: connected) {
            if ((p.y < SIZE-1 && board[p.x][p.y + 1] == NONE) || (p.y > 0 && board[p.x][p.y - 1] == NONE) ||
                    (p.x < SIZE-1 && board[p.x + 1][p.y] == NONE) || (p.x > 0 && board[p.x - 1][p.y] == NONE)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void addStone(int x, int y) throws IllegalArgumentException{
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
            throw new IllegalArgumentException();
        }
        if (board[x][y] != NONE) {
            throw new IllegalArgumentException();
        }
        board[x][y] = getCurrentColor();
        if (isSurrounded(getCurrentColor(),searchConnected(x, y, getCurrentColor(), new boolean[SIZE][SIZE]))) {
            board[x][y] = NONE;
            throw new IllegalArgumentException();
        }
        turn++;
    }

    @Override
    public int[][] getData() {
        return board;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public boolean win() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((board[i][j] != NONE) && isSurrounded(board[i][j],
                        searchConnected(i,j,board[i][j],new boolean[SIZE][SIZE]))) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int getSize() {
        return SIZE;
    }
}
