package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Engine implements KeyboardHandler {
    private Grid grid;
    private Cursor cursor;
    private Color color;
    private boolean paintActivated = false;
    private Text currentColor;
    private Text isPaintActivated;

    public Engine(){
        grid = new Grid();
        color = Color.BLACK;
        printInfoText();
    }

    public void start(){
        grid.startGrid();
        cursor = new Cursor(0, 0);
    }

    KeyboardListener keyb = new KeyboardListener(this);

    @Override
    public void keyPressed(KeyboardEvent event) {
        int x = cursor.getX();
        int y = cursor.getY();

        switch (event.getKey()){
            case KeyboardEvent.KEY_DOWN:
                if(y < Values.ROWS-1) {
                    if (paintActivated) {
                        grid.gridPaint(x, y, color);
                    }
                    cursor.moveCursorDown();
                }
                break;
            case KeyboardEvent.KEY_UP:
                if(y > 0) {
                    if (paintActivated) {
                        grid.gridPaint(x, y, color);
                    }
                    cursor.moveCursorUp();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if(x > 0) {
                    if (paintActivated) {
                        grid.gridPaint(x, y, color);
                    }
                    cursor.moveCursorLeft();
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if(x < Values.COLS-1) {
                    if (paintActivated) {
                        grid.gridPaint(x, y, color);
                    }
                    cursor.moveCursorRight();
                }
                break;

            case KeyboardEvent.KEY_C:
                if (color == Color.BLACK) {
                    color = Color.BLUE;
                    currentColor.setText("Current Color: Blue.");
                    break;
                }
                if (color == Color.BLUE) {
                    color = Color.RED;
                    currentColor.setText("Current Color: Red.");
                    break;
                }
                if (color == Color.RED) {
                    color = Color.GREEN;
                    currentColor.setText("Current Color: Green.");
                    break;
                }
                if (color == Color.GREEN) {
                    color = Color.BLACK;
                    currentColor.setText("Current Color: Black.");
                    break;
                }

            case KeyboardEvent.KEY_V:
                paintActivated = !paintActivated;
                if(paintActivated) {
                    isPaintActivated.setText("Paint is Activated.");
                } else {
                    isPaintActivated.setText("Paint is not Activated.");
                }
                break;

            case KeyboardEvent.KEY_R:
                grid = new Grid();
                grid.clearGrid();
                grid.startGrid();
                break;

            case KeyboardEvent.KEY_S:
                FileIO.save(grid.getContainer());
                break;

            case KeyboardEvent.KEY_L:
                grid = FileIO.load();
                Values.LOADED = true;
                start();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        /**
         * Not implemented.
         */
    }

    private void printInfoText(){
        currentColor = new Text (20, Values.ROWS * Values.CELL_SIZE + 20, "Current Color: Black"); //Class variable, as it changes during runtime.
        isPaintActivated = new Text (20, Values.ROWS * Values.CELL_SIZE + 40, "Paint Not Activated.");
        Text keys = new Text (20, Values.ROWS * Values.CELL_SIZE + 60, "C: Changes Colors    V: Toggles Painter ON/OFF");
        Text keys2 = new Text (20, Values.ROWS * Values.CELL_SIZE + 80, "R: Resets Grid      S: Saves      L: Load");

        currentColor.draw();
        isPaintActivated.draw();
        keys.draw();
        keys2.draw();
    }
}
