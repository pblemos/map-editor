package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private Cell[][] container;

    public Grid(){
        container = new Cell[Values.ROWS][Values.COLS];
        populateGrid();
    }

    public void populateGrid() {
        for(int i = 0; i < Values.ROWS; i++){
            for (int j = 0; j < Values.COLS; j++) {
                container[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getContainer() {
        return container;
    }

    public void startGrid(){
        clearGrid();
        for(int i = 0; i < Values.ROWS; i++){
            for (int j = 0; j < Values.COLS; j++) {
                Rectangle rect = new Rectangle(container[i][j].getX(), container[i][j].getY(), Values.CELL_SIZE, Values.CELL_SIZE);
                if (container[i][j].getColor() != Color.WHITE) {
                    rect.setColor(container[i][j].getColor());
                    rect.fill();
                    continue;
                }

                rect.draw();
            }
        }
    }

    public void clearGrid(){
        Rectangle rectangle = new Rectangle(0, 0, Values.ROWS*Values.CELL_SIZE + Values.PADDING, Values.COLS * Values.CELL_SIZE + Values.PADDING);
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
    }

    public void gridPaint(int x, int y, Color color){
        if (color == Color.WHITE) {
            container[x][x].fill();
            return;
        }
        container[x][y].paint(color);
        return;
    }

    public void gridPaint(int x, int y, boolean b) {
        Color c = container[x][y].getColor();
        container[x][y].paint(c);
    }
}
