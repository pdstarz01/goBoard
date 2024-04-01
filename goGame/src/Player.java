import java.util.Scanner;

public class Player {
    static Scanner scan;
    String piece  = "";
    public static int[] PlayerTurn(){
        System.out.print("What is the X point you want to place a piece?:");
        System.out.println();
        int moveX = scan.nextInt();
        System.out.print("What is the Y point you want to place a piece?:");
        System.out.println();
        int moveY = scan.nextInt();
        int move[] = new int[]{moveX,moveY};
        return move;
        /*
        try {
            Board[moveX-1][moveY-1] = piece;
        }
        catch(Exception e) {
            System.out.print("Invalid Input");
        }
        */
    }
}
