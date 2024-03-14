import java.util.Scanner;
public class Minesweeper {
    private Tile[][] mineField;
    private Scanner scan;
    public Minesweeper() {
        scan = new Scanner(System.in);
        setupMinefield();
        start();
    }

    public void start() {

    }

    public void setupMinefield() {
        System.out.println("What difficulty would you like?");
        System.out.print("(e)asy, (m)edium, or (h)ard: ");
        String difficulty = scan.nextLine();
        //set board size + num mines depending on difficulty, see minesweeper wikipedia page
    }

}
