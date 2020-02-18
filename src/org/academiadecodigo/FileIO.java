package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;

import static org.academiadecodigo.simplegraphics.graphics.Color.*;

public class FileIO {
    public static Grid load() {
        Grid grid = new Grid();
        Cell[][] container = grid.getContainer();
        try {
            FileReader fileReader = new FileReader(Values.FILE);
            BufferedReader bReader = new BufferedReader(fileReader);

            for(int i = 0; i < Values.ROWS; i++) {
                for (int j = 0; j < Values.COLS; j++) {
                    String loaded = bReader.readLine();
                    if (loaded.equals("bc")){
                        container[i][j].setColor(BLACK);
                    }
                    if (loaded.equals("bl")){
                        container[i][j].setColor(BLUE);
                    }
                    if (loaded.equals("r")){
                        container[i][j].setColor(RED);
                    }
                    if (loaded.equals("g")){
                        container[i][j].setColor(GREEN);
                    }
                }
            }
            bReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return grid;
        }
    }

    public static void save(Cell[][] container){
        try {
            FileWriter writer = new FileWriter(Values.FILE);
            BufferedWriter bWriter = new BufferedWriter(writer);

            for(int i = 0; i < Values.ROWS; i++){
                for (int j = 0; j < Values.COLS; j++) {
                    Color color = container[i][j].getColor();
                    String returnS = "";
                    if (color == BLACK){
                        returnS = "bc";
                    }
                    if (color == BLUE){
                        returnS = "bl";
                    }
                    if (color == RED){
                        returnS = "r";
                    }
                    if (color == GREEN){
                        returnS = "g";
                    }
                    if (color == WHITE){
                        returnS = "w";
                    }

                    bWriter.write(returnS);
                    bWriter.newLine();
                }
            }
            bWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
