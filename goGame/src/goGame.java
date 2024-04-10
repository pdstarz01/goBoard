public class goGame {
    static Player Black  = new Player();
    static Player White  = new Player();
    static Board goBoard = new Board();
    static String[][] capturedBoard = GridFunctions.capturedBoard(9,9);
    static String empty = " + ";
    public static void main(String[] args) {
        Initialize_Game();
        Player_Turn(Black, White);
    }
    public static void Initialize_Game(){
        Black.piece = " O ";
        Black.name = "Black";
        White.piece = " X ";
        White.name = "White";
        goBoard.Create_Board();
    }
    public static void Player_Turn(Player player, Player next){
        System.out.println(player.name + "'s Turn\n");
        int move[] = player.Place_Piece();
        int moveX = move[0]-1;
        int moveY = move[1]-1;
        try {
            if((goBoard.board[moveY][moveX] == " X ") || (goBoard.board[moveY][moveX] == " O ")){
                System.out.println("There is already a piece there! Pick another location\n");
                Player_Turn(player, next);
            }
            else {
                goBoard.board[moveY][moveX] = player.piece;
            }
        }
        catch(Exception e) {
            System.out.print("Invalid Input, Pick another location\n");
            Player_Turn(player, next);
        }
        goBoard.Print_Board();
        for (int i = 0; i < goBoard.board.length; i++) {
            for (int j = 0; j < goBoard.board[i].length; j++) {
                GridFunctions.singularCapture(goBoard.board, capturedBoard, i, j, Black, White);
            }
        }
        System.out.println("The Score is:\n" + Black.name + " has " + Black.points + ".\n" + White.name + " has " + White.points + ".\n");
        Player_Turn(next, player);
    }
}