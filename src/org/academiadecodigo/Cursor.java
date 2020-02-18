package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {
    private int x;
    private int y;
    private Color cursorColor = Color.GREEN;
    private Rectangle rect;

    public Cursor(int x, int y){
        this.x = x;
        this.y = y;
        rect = new Rectangle(x * Values.CELL_SIZE + Values.PADDING, y * Values.CELL_SIZE + Values.PADDING
                , Values.CELL_SIZE, Values.CELL_SIZE);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * Methods already verified when invoked.
     */
    public void moveCursorUp(){
        y--;
        paint(cursorColor);
    }

    public void moveCursorDown(){
        y++;
        paint(cursorColor);
    }

    public void moveCursorLeft(){
        x--;
        paint(cursorColor);
    }

    public void moveCursorRight(){
        x++;
        paint(cursorColor);
    }

    private void paint(Color color){
        rect.delete();
        rect = new Rectangle(x * Values.CELL_SIZE + Values.PADDING, y * Values.CELL_SIZE + Values.PADDING
                , Values.CELL_SIZE, Values.CELL_SIZE);
        rect.setColor(cursorColor);
        rect.fill();
    }
}
