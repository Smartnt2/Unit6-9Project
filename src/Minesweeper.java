import java.util.Locale;
import java.util.Scanner;
public class Minesweeper {
    private int totalMines;
    private Tile[][] mineField;
    private Scanner scan;
    public Minesweeper() {
        scan = new Scanner(System.in);
        setupMinefield();
        start();
    }

    public void start() {
        printMinefield();
    }

    public void setupMinefield() {
        System.out.println("What difficulty would you like?");
        System.out.print("(e)asy, (m)edium, or (h)ard: ");
        String difficulty = scan.nextLine().toLowerCase();
        //set board size + num mines depending on difficulty, see minesweeper wikipedia page
        //could use totalMines for generating mines and for showing mines remaining (totalMines - number of flags on grid), can be negative
        if(difficulty.equals("e")) {
            //9x9, 10 mines
            mineField = new Tile[9][9];
            totalMines = 10;
            for(int r = 0; r < mineField.length; r++) {
                for(int c = 0; c  < mineField[0].length; c++) {
                    mineField[r][c] = new Tile("_");
                }
            }
            printMinefield();

        }
         else if(difficulty.equals("m")) {
            //16x16, 40 mines
            mineField = new Tile[16][16];
            totalMines = 40;
            for(int r = 0; r < mineField.length; r++) {
                for(int c = 0; c  < mineField[0].length; c++) {
                    mineField[r][c] = new Tile("_");
                }
            }


        }
        else if(difficulty.equals("h")) {
            //16x30, 99 mines
            mineField = new Tile[16][30];
            totalMines = 99;
            for(int r = 0; r < mineField.length; r++) {
                for(int c = 0; c  < mineField[0].length; c++) {
                    mineField[r][c] = new Tile("_");
                }
            }
            printMinefield();

        } else {
            System.out.println("Not an option");
            setupMinefield();
        }

    }

    public void printMinefield() {
        for(Tile[] row : mineField) {
            for(Tile tile: row) {
                System.out.print(tile.getSymbol());
            }
            System.out.println();
        }
    }

}
