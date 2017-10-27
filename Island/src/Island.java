

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javalib.impworld.*;
import javalib.worldimages.*;
import tester.*;



//Represents a single square of the game area

class Cell {

    // represents absolute height of this cell, in feet

    double height;

    // In logical coordinates, with the origin at the top-left corner of the

    // screen

    int x;

    int y;

    // the four adjacent cells to this one

    Cell left;

    Cell top;

    Cell right;

    Cell bottom;

    // reports whether this cell is flooded or not

    boolean isFlooded;



    Cell(int x, int y, double height) {

        this.x = x;

        this.y = y;

        this.height = height;

        this.isFlooded = false;

        this.left = null;

        this.top = null;

        this.right = null;

        this.bottom = null;

    }



    WorldImage displayCell(int waterHeight) {

        Color color = null;

        double heightDiff = waterHeight - this.height;

        if (this.isFlooded && heightDiff < 32) {

            color = new Color(0, 0, 128 - (int) (heightDiff * 4));

        } else if (this.isFlooded) {

            color = new Color(0, 0, 0);

        } else if (this.height <= waterHeight) {

            color = new Color((int) (heightDiff * 4),

                    128 - (int) (heightDiff * 4), 0);

        } else {

            double heightPercent = -(heightDiff)

                    / ForbiddenIslandWorld.ISLAND_MAX_HEIGHT;

            color = new Color(0, 128, 0, 255 - (int) (255 * heightPercent));

        }

        return new RectangleImage(10, 10, OutlineMode.SOLID, color);

    }



    boolean cellEquals(Cell that) {

        return this.x == that.x && this.y == that.y;

    }

}



class OceanCell extends Cell {



    OceanCell(int x, int y, double height) {

        super(x, y, height);

        this.isFlooded = true;

    }



    WorldImage displayCell(int waterHeight) {

        Color color = new Color(10, 10, 128);

        return new RectangleImage(10, 10, OutlineMode.SOLID, color);

    }

}



class ForbiddenIslandWorld extends World {

    // size of an island

    static final int ISLAND_SIZE = 64;

    static final int ISLAND_MAX_HEIGHT = ISLAND_SIZE / 2;

    // All the cells of the game, including the ocean

    IList<Cell> board = new Empty<Cell>();

    // the current height of the ocean

    int waterHeight;

    int ticks;

    Player player;

    IList<Target> targets;

    Target helicopter;

    // 0 : game is running

    // -1 : player lost

    // 1 : player won

    int end;



    ForbiddenIslandWorld() {

        super();

        this.waterHeight = 0;

        this.ticks = 0;

        this.end = 0;

    }



    Cell makeCell(int x, int y, double height) {

        if (height > this.waterHeight) {

            return new Cell(x, y, height);

        } else {

            return new OceanCell(x, y, height);

        }

    }



    void initUnits() {

        this.player = new Player(this.board);

        this.targets = new Cons<Target>(new Target(this.board),

                new Empty<Target>());

        this.targets = new Cons<Target>(new Target(this.board), this.targets);

        this.targets = new Cons<Target>(new Target(this.board), this.targets);

        this.targets = new Cons<Target>(new Target(this.board), this.targets);

        this.helicopter = new HelicopterTarget(this.board);

    }



    WorldScene displaysTargets(WorldScene ws) {

        Iterator<Target> iter = this.targets.getIterator();

        while (iter.hasNext()) {

            iter.next().display(ws);

        }

        return ws;



    }



    public WorldScene makeScene() {

        WorldScene ws = new WorldScene(ISLAND_SIZE * 10, ISLAND_SIZE * 10);

        Iterator<Cell> cellIter = this.board.getIterator();

        while (cellIter.hasNext()) {

            Cell cell = cellIter.next();

            ws.placeImageXY(cell.displayCell(this.waterHeight), cell.x * 10,

                    cell.y * 10);

            this.helicopter.display(ws);

            this.displaysTargets(ws);

            this.player.display(ws);

        }

        return ws;

    }



    void setBoard() {

        ArrayList<ArrayList<Cell>> cells = this.generateCells();

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                this.board = new Cons<Cell>(cells.get(x).get(y), this.board);

            }

        }

        this.initUnits();

    }



    ArrayList<ArrayList<Cell>> generateCells() {

        ArrayList<ArrayList<Cell>> cells = new ArrayList<ArrayList<Cell>>();

        ArrayList<ArrayList<Double>> heights = this

                .generateHeights(ISLAND_MAX_HEIGHT);

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            cells.add(new ArrayList<Cell>());

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                double height = heights.get(x).get(y);

                cells.get(x).add(this.makeCell(x, y, height));

            }

        }

        this.setAdjacent(cells);

        return cells;

    }



    void setAdjacent(ArrayList<ArrayList<Cell>> cells) {

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                if (x > 0) {

                    cells.get(x).get(y).left = cells.get(x - 1).get(y);

                } else {

                    cells.get(x).get(y).left = cells.get(x).get(y);

                }

                if (x < ISLAND_SIZE) {

                    cells.get(x).get(y).right = cells.get(x + 1).get(y);

                } else {

                    cells.get(x).get(y).right = cells.get(x).get(y);

                }

                if (y > 0) {

                    cells.get(x).get(y).top = cells.get(x).get(y - 1);

                } else {

                    cells.get(x).get(y).top = cells.get(x).get(y);

                }

                if (y < ISLAND_SIZE) {

                    cells.get(x).get(y).bottom = cells.get(x).get(y + 1);

                } else {

                    cells.get(x).get(y).bottom = cells.get(x).get(y);

                }

            }

        }

    }



    ArrayList<ArrayList<Double>> generateHeights(int peak) {

        ArrayList<ArrayList<Double>> heights = new ArrayList<ArrayList<Double>>();

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            heights.add(new ArrayList<Double>());

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                heights.get(x).add((double) peak);

            }

        }

        return heights;

    }



    @Override

    public void onTick() {

        if (this.ticks % 10 == 0 && this.ticks != 0) {

            this.waterHeight += 1;

        }

        this.ticks += 1;

        this.flood(this.board.getIterator());

        this.end = this.isUnitFlooded();

        this.targets = this.collectTargets();

        this.flyAway();

    }



    void flood(Iterator<Cell> cellIter) {

        IList<Cell> cells = new Empty<Cell>();

        while (cellIter.hasNext()) {

            Cell cell = cellIter.next();

            if (!cell.isFlooded && cell.height <= this.waterHeight) {

                if (cell.bottom.isFlooded || cell.top.isFlooded

                        || cell.left.isFlooded || cell.right.isFlooded) {

                    cell.isFlooded = true;

                }

            }

        }

    }



    int isUnitFlooded() {



        if (this.player.currentCell.isFlooded) {

            return -1;

        }

        if (this.helicopter.locCell.isFlooded) {

            return -1;

        }

        Iterator<Target> iter = this.targets.getIterator();

        while (iter.hasNext()) {

            if (iter.next().locCell.isFlooded) {

                return -1;

            }

        }



        return 0;

    }



    IList<Target> collectTargets() {

        Iterator<Target> iter = this.targets.getIterator();

        IList<Target> result = new Empty<Target>();

        while (iter.hasNext()) {

            Target target = iter.next();

            if (!target.locCell.cellEquals(this.player.currentCell)) {

                result = new Cons<Target>(target, result);

            }

        }

        return result;

    }



    void flyAway() {

        if (this.player.currentCell.cellEquals(this.helicopter.locCell)

                && !this.targets.isCons()) {

            this.end = 1;

        }

    }



    public void onKeyEvent(String ke) {

//        if (ke.equals("m")) {
//
//            this.stopWorld();
//
//            DiamondMountain world = new DiamondMountain();
//
//            world.bigBang(ISLAND_SIZE * 10, ISLAND_SIZE * 10, 0.3);
//
//        }
//
//        if (ke.equals("r")) {
//
//            this.stopWorld();
//
//            DiamondRandom world = new DiamondRandom();
//
//            world.bigBang(ISLAND_SIZE * 10, ISLAND_SIZE * 10, 0.3);
//
//        }
//
//        if (ke.equals("t")) {
//
//            this.stopWorld();
//
//            RandomIsland world = new RandomIsland();
//
//            world.bigBang(ISLAND_SIZE * 10, ISLAND_SIZE * 10, 0.3);
//
//        }

        if (ke.equals("left")) {

            this.player.moveLeft();

        }

        if (ke.equals("right")) {

            this.player.moveRight();

        }

        if (ke.equals("up")) {

            this.player.moveUp();

        }

        if (ke.equals("down")) {

            this.player.moveDown();

        }



    }



    public WorldEnd worldEnds() {

        if (this.end == 1) {

            WorldImage endGameText = new TextImage("You WON!", ISLAND_SIZE * 2,

                    Color.GREEN);

            WorldScene ws = new WorldScene(ISLAND_SIZE * 10, ISLAND_SIZE * 10);

            ws.placeImageXY(endGameText, ISLAND_SIZE * 5, ISLAND_SIZE * 5);

            return new WorldEnd(true, ws);

        } else if (this.end == -1) {

            WorldImage endGameText = new TextImage("You LOST!", ISLAND_SIZE * 2,

                    Color.RED);

            WorldScene ws = new WorldScene(ISLAND_SIZE * 10, ISLAND_SIZE * 10);

            ws.placeImageXY(endGameText, ISLAND_SIZE * 5, ISLAND_SIZE * 5);

            return new WorldEnd(true, ws);

        } else {

            return new WorldEnd(false, makeScene());

        }

    }

}



class DiamondMountain extends ForbiddenIslandWorld {



    DiamondMountain() {

        super();

        this.setBoard();



    }



    ArrayList<ArrayList<Double>> generateHeights(int peak) {

        ArrayList<ArrayList<Double>> heights = new ArrayList<ArrayList<Double>>();

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            heights.add(new ArrayList<Double>());

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                double manDist = (Math.abs(x - (ISLAND_SIZE / 2))

                        + Math.abs(y - (ISLAND_SIZE / 2)));

                double height = peak - manDist;

                heights.get(x).add(height);

            }

        }

        return heights;

    }

}



class DiamondRandom extends ForbiddenIslandWorld {



    DiamondRandom() {

        super();

        this.setBoard();

    }



    ArrayList<ArrayList<Double>> generateHeights(int peak) {

        ArrayList<ArrayList<Double>> heights = new ArrayList<ArrayList<Double>>();

        Random random = new Random();

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            heights.add(new ArrayList<Double>());

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                double manDist = (Math.abs(x - (ISLAND_SIZE / 2))

                        + Math.abs(y - (ISLAND_SIZE / 2)));

                double height = peak - manDist;

                if (height > 0) {

                    height = random.nextDouble() * 32;

                    heights.get(x).add(height);

                } else {

                    heights.get(x).add(height);

                }

            }

        }

        return heights;

    }

}



class RandomIsland extends ForbiddenIslandWorld {



    RandomIsland() {

        super();

        this.setBoard();

    }



    ArrayList<ArrayList<Double>> generateHeights(int peak) {

        ArrayList<ArrayList<Double>> heights = new ArrayList<ArrayList<Double>>();

        for (int x = 0; x <= ISLAND_SIZE; x += 1) {

            heights.add(new ArrayList<Double>());

            for (int y = 0; y <= ISLAND_SIZE; y += 1) {

                heights.get(x).add(0.0);

            }

        }

        heights.get((ISLAND_SIZE / 2)).set(0, 1.0);

        heights.get(0).set((ISLAND_SIZE / 2), 1.0);

        heights.get(ISLAND_SIZE).set((ISLAND_SIZE / 2), 1.0);

        heights.get((ISLAND_SIZE / 2)).set(ISLAND_SIZE, 1.0);

        heights.get((ISLAND_SIZE / 2)).set((ISLAND_SIZE / 2), (double) peak);



        this.heightsHelper(heights, 0, 0, (ISLAND_SIZE / 2));

        this.heightsHelper(heights, (ISLAND_SIZE / 2), 0, (ISLAND_SIZE / 2));

        this.heightsHelper(heights, 0, (ISLAND_SIZE / 2), (ISLAND_SIZE / 2));

        this.heightsHelper(heights, (ISLAND_SIZE / 2), (ISLAND_SIZE / 2),

                (ISLAND_SIZE / 2));

        return heights;

    }



    void heightsHelper(ArrayList<ArrayList<Double>> heights, int x, int y,

            int size) {

        Random random = new Random();



        double tl = heights.get(x).get(y);

        double tr = heights.get(x + size).get(y);

        double bl = heights.get(x).get(y + size);

        double br = heights.get(x + size).get(y + size);



        double t = ((tl + tr) / 2)

                + ((size * random.nextDouble()) - (size / 2 + 2));

        heights.get(x + (size / 2)).set(y, t);

        double l = ((tl + bl) / 2)

                + ((size * random.nextDouble()) - (size / 2 + 2));

        heights.get(x).set(y + (size / 2), l);

        double r = ((tr + br) / 2)

                + ((size * random.nextDouble()) - (size / 2 + 2));

        heights.get(size).set(y + (size / 2), r);

        double b = ((bl + br) / 2)

                + ((size * random.nextDouble()) - (size / 2 + 2));

        heights.get(x + (size / 2)).set(size, b);



        double m = ((tl + tr + bl + br) / 4)

                + ((size * random.nextDouble()) - (size / 2 + 2));

        heights.get(x + (size / 2)).set(y + (size / 2), m);



        if (size / 2 > 1) {

            this.heightsHelper(heights, x, y, (size / 2));

            this.heightsHelper(heights, x + (size / 2), y, (size / 2));

            this.heightsHelper(heights, x, y + (size / 2), (size / 2));

            this.heightsHelper(heights, x + (size / 2), y + (size / 2),

                    (size / 2));

        }



    }

}



class Player {

    Cell currentCell;



    Player(IList<Cell> cells) {

        this.initCell(cells);

    }



    private void initCell(IList<Cell> cells) {

        currentCell = null;

        Random random = new Random();

        while (currentCell == null) {

            Iterator<Cell> iter = cells.getIterator();

            int count = random.nextInt(ForbiddenIslandWorld.ISLAND_SIZE

                    * ForbiddenIslandWorld.ISLAND_SIZE);

            for (int i = 0; i < count - 1; i += 1) {

                iter.next();

            }

            Cell cell = iter.next();

            System.out.println(cell.height);

            if (cell.height > 5) {

                currentCell = cell;

            }



        }

    }



    WorldScene display(WorldScene ws) {

        WorldImage image = new FromFileImage("pilot.png");

        ws.placeImageXY(image, this.currentCell.x * 10,

                this.currentCell.y * 10);

        return ws;

    }



    void moveRight() {

        if (!this.currentCell.right.isFlooded) {

            this.currentCell = this.currentCell.right;

        }

    }



    void moveLeft() {

        if (!this.currentCell.left.isFlooded) {

            this.currentCell = this.currentCell.left;

        }

    }



    void moveUp() {

        if (!this.currentCell.top.isFlooded) {

            this.currentCell = this.currentCell.top;

        }

    }



    void moveDown() {

        if (!this.currentCell.bottom.isFlooded) {

            this.currentCell = this.currentCell.bottom;

        }

    }

}



class Target {

    Cell locCell;



    Target(IList<Cell> cells) {

        this.initCell(cells);

    }



    private void initCell(IList<Cell> cells) {

        locCell = null;

        Random random = new Random();

        while (locCell == null) {

            Iterator<Cell> iter = cells.getIterator();

            int count = random.nextInt(ForbiddenIslandWorld.ISLAND_SIZE

                    * ForbiddenIslandWorld.ISLAND_SIZE);

            for (int i = 0; i < count - 1; i += 1) {

                iter.next();

            }

            Cell cell = iter.next();

            System.out.println(cell.height);

            if (cell.height > 10) {

                locCell = cell;

            }



        }

    }



    WorldScene display(WorldScene ws) {

        WorldImage image = new CircleImage(5, OutlineMode.SOLID, Color.RED);

        ws.placeImageXY(image, this.locCell.x * 10, this.locCell.y * 10);

        return ws;

    }



}



class HelicopterTarget extends Target {

    HelicopterTarget(IList<Cell> cells) {

        super(cells);

        this.initCell(cells);

    }



    private void initCell(IList<Cell> cells) {

        Iterator<Cell> iter = cells.getIterator();

        int count = (ForbiddenIslandWorld.ISLAND_SIZE

                * ForbiddenIslandWorld.ISLAND_SIZE) / 2;

        for (int i = 0; i < count - 1; i += 1) {

            iter.next();

        }

        locCell = iter.next();

    }



    WorldScene display(WorldScene ws) {

        WorldImage image = new FromFileImage("helicopter.png");

        ws.placeImageXY(image, this.locCell.x * 10, this.locCell.y * 10);

        return ws;

    }

}



interface Iterator<T> {

    boolean hasNext();



    T next();

}



class IListIterator<T> implements Iterator<T> {



    IList<T> list;



    IListIterator(IList<T> list) {

        this.list = list;

    }



    public boolean hasNext() {

        return this.list.isCons();

    }



    public T next() {

        Cons<T> cons = this.list.asCons();

        T result = cons.first;

        this.list = cons.rest;

        return result;

    }

}



interface Iterable<T> {

    Iterator<T> getIterator();

}



interface IList<T> extends Iterable<T> {

    boolean isCons();



    Cons<T> asCons();

}



// Represents an empty list of objects of a single type

class Empty<T> implements IList<T> {

    public Iterator<T> getIterator() {

        return new IListIterator<T>(this);

    }



    public boolean isCons() {

        return false;

    }



    public Cons<T> asCons() {

        return new Cons<T>(null, this);

    }

}



// Represents a non-empty list of objects

class Cons<T> implements IList<T> {

    T first;

    IList<T> rest;



    Cons(T first, IList<T> rest) {

        this.first = first;

        this.rest = rest;

    }



    public Iterator<T> getIterator() {

        return new IListIterator<T>(this);

    }



    public boolean isCons() {

        return true;

    }



    public Cons<T> asCons() {

        return (Cons<T>) this;

    }

}



class ExamplesGame {



    ForbiddenIslandWorld world = new ForbiddenIslandWorld();



    boolean testmakeCell(Tester t) {

        return t.checkExpect(this.world.makeCell(50, 50, 20),

                new Cell(50, 50, 20))

                && t.checkExpect(this.world.makeCell(50, 50, -20),

                        new OceanCell(50, 50, -20));

    }



    void testRandomIsland(Tester t) {

        RandomIsland island = new RandomIsland();
       

        island.bigBang(ForbiddenIslandWorld.ISLAND_SIZE * 10,

                ForbiddenIslandWorld.ISLAND_SIZE * 10, .3);

    }

}