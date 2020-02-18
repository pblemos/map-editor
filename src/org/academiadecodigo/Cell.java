package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private Color color;
    private Rectangle rectangle;
    private int x;
    private int y;

    public Cell(int x, int y){
        this.color = Color.WHITE;
        this.x = x * Values.CELL_SIZE + Values.PADDING;
        this.y = y * Values.CELL_SIZE + Values.PADDING;
        rectangle = new Rectangle();
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x * Values.CELL_SIZE + Values.PADDING;
    }

    public void setY(int y) {
        this.y = y * Values.CELL_SIZE + Values.PADDING;
    }

    public void paint(Color newColor){
        color = newColor;
        rectangle = new Rectangle(x, y, Values.CELL_SIZE, Values.CELL_SIZE);
        rectangle.setColor(color);
        if (color != Color.WHITE) {
            rectangle.fill();
        } else {
            rectangle.draw();
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void fill(){
        rectangle = new Rectangle(x, y, Values.CELL_SIZE, Values.CELL_SIZE);
        rectangle.fill();
    }
}
