import java.util.Scanner;

public class Board {

    static Scanner scan = new Scanner(System.in);

    static String Black_Piece = new String(" O ");
    static String White_Piece = new String(" * ") ;

    static String Board[][] = new String[19][19];

    static String Current_Player = "Black";
    static int Turn_Count = 0;

    public static void main(String[] args) {
        CreateBoard();
    }
    public static void CreateBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Board[i][j] = " + ";
                System.out.print(Board[i][j]);
            }
            System.out.println();
        }
    }
    public static void PrintBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Board[i][j]);
            }
            System.out.println();
        }
    }
}