import java.util.Scanner;
public class Minesweeper {
    private int selectedR;
    private int selectedC;
    private int totalMines;
    private Tile[][] mineField;
    private Scanner scan;
    private boolean gameOver;
    public Minesweeper() {
        gameOver = false;
        selectedR = 0;
        selectedC = 0;
        scan = new Scanner(System.in);
        setupMinefield();
        start();
    }

    public void start() {
        //need to add flag and click option
        while(!gameOver) {
            printMinefield();
            System.out.print("Enter a direction to move cursor (wasd) or (z) to sweep and (c) to add/remove flag: ");
            String input = scan.nextLine();
            if(input.equals("z")) {
                sweep();
            } else if(input.equals("c")) {
                flag();
            } else if(!move(input)) {
                System.out.println("You cannot move there!");
            }

        }
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
                    mineField[r][c] = new Tile("◻\uFE0F");
                }
            }

        }
        else if(difficulty.equals("m")) {
            //16x16, 40 mines
            mineField = new Tile[16][16];
            totalMines = 40;
            for(int r = 0; r < mineField.length; r++) {
                for(int c = 0; c  < mineField[0].length; c++) {
                    mineField[r][c] = new Tile("◻\uFE0F");
                }
            }

        }
        else if(difficulty.equals("h")) {
            //16x30, 99 mines
            mineField = new Tile[16][30];
            totalMines = 99;
            for(int r = 0; r < mineField.length; r++) {
                for(int c = 0; c  < mineField[0].length; c++) {
                    mineField[r][c] = new Tile("◻\uFE0F");
                }
            }

        } else {
            System.out.println("Not an option");
            setupMinefield();
        }
        //place cursor
        mineField[0][0].setSymbol("[" + "◻\uFE0F" + "]");
        //generate mines;
        for(int i = 0; i < totalMines; i++) {
            int randomR = (int) (Math.random() * (mineField.length));
            int randomC = (int) (Math.random() * (mineField[0].length));
            while(mineField[randomR][randomC] instanceof Mine) {
                randomR = (int) (Math.random() * (mineField.length));
                randomC = (int) (Math.random() * (mineField[0].length));
            }
            mineField[randomR][randomC] = new Mine("◻\uFE0F");
        }
    }

    public void printMinefield() {
        //Print the current state of the minefield
        for (int r = 0; r < mineField.length; r++) {
            for (int c = 0; c < mineField[0].length; c++) {
                if (mineField[r][c] instanceof Mine) {
                    System.out.print(mineField[r][c].getSymbol());
                } else {
                    System.out.print(mineField[r][c].getSymbol());
                }
            }
            System.out.println();
        }
    }

    public boolean move(String direction)  {
        //adapted from U9T5 gridGame
        if(direction.equals("w")) {
            if(selectedR - 1 >= 0) {
                mineField[selectedR][selectedC].setSymbol("◻\uFE0F");
                mineField[selectedR-1][selectedC].setSymbol("[" + mineField[selectedR-1][selectedC].getSymbol() + "]");
                selectedR--;
                return true;
            }

        } if(direction.equals("s")) {
            if(selectedR + 1 < mineField.length) {
                mineField[selectedR][selectedC].setSymbol("◻\uFE0F");
                mineField[selectedR+1][selectedC].setSymbol("[" + mineField[selectedR+1][selectedC].getSymbol() + "]");
                selectedR++;
                return true;
            }
        } if(direction.equals("a")) {
            if(selectedC - 1 >= 0) {
                mineField[selectedR][selectedC].setSymbol("◻\uFE0F");
                mineField[selectedR][selectedC-1].setSymbol("[" + mineField[selectedR][selectedC-1].getSymbol() + "]");
                selectedC--;
                return true;
            }
        } if(direction.equals("d")) {
            if(selectedC + 1 < mineField[0].length) {
                mineField[selectedR][selectedC].setSymbol("◻\uFE0F");
                mineField[selectedR][selectedC+1].setSymbol("[" + mineField[selectedR][selectedC+1].getSymbol() + "]");
                selectedC++;
                return true;
            }
        }
        return false;
    }

    //implement later
    public boolean sweep() {
        return false;
    }

    public boolean flag() {
        return false;
    }

}
