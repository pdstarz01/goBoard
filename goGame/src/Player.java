import java.util.Scanner;

public class Player {
    
    static Scanner scan = new Scanner(System.in);
    String piece = "";
    String name  = "";
    public int[] Place_Piece(){
        System.out.print("What is the X point you want to place a piece?:\n");
        int moveX = scan.nextInt();
        System.out.print("What is the Y point you want to place a piece?:\n");
        int moveY = scan.nextInt();
        int move[] = new int[]{moveX,moveY};
        return move;
        /*
        */
    }
}
