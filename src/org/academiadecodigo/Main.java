package org.academiadecodigo;

public class Main {
    private static boolean ableToStart = false;

    public static void main(String[] args) {
        parseArgs(args);
        if(ableToStart) {
            Engine engine = new Engine();
            engine.start();
        }
    }

    private static void parseArgs(String[] args) {
        if(args.length == 3) { //Values can be Forced on Values Class
            try {
                if (Values.CELL_SIZE == 0) { //Not forced, parses args
                    Values.COLS = Integer.parseInt(args[0]);
                    Values.ROWS = Integer.parseInt(args[1]);
                    Values.CELL_SIZE = Integer.parseInt(args[2]);
                    ableToStart = true;
                }
            } catch (Exception e) {
                System.err.println("Invalid inputs. Couldn't parse Integer.");
                System.err.println(e.getMessage());
            }
        } else {
            if(Values.CELL_SIZE != 0) {
                ableToStart = true;
                return;
            }
            System.err.println("Start with arguments: <Cols> <Rows> <Cell Size>");
        }
    }
}
