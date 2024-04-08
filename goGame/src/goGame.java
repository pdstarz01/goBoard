public class goGame {
    static Player Black  = new Player();
    static Player White  = new Player();
    static Board goBoard = new Board();
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
        int moveX = move[0];
        int moveY = move[1];
        try {
            if((goBoard.board[moveX-1][moveY-1] == " X ") || (goBoard.board[moveX-1][moveY-1] == " O ")){
                System.out.println("There is already a piece there! Pick another location\n");
                Player_Turn(player, next);
            }
            else {
                goBoard.board[moveY-1][moveX-1] = player.piece;
            }
        }
        catch(Exception e) {
            System.out.print("Invalid Input, Pick another location\n");
            Player_Turn(player, next);
        }
        goBoard.Print_Board();
        Player_Turn(next, player);
    }
    public boolean Can_Breathe(int x, int y, String allyPiece){
        boolean canBreathe = true;
        if((goBoard.board[x+1][y] == " + ") || (goBoard.board[x+1][y] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x][y+1] == " + ") || (goBoard.board[x][y+1] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x-1][y] == " + ") || (goBoard.board[x-1][y] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x][y-1] == " + ") || (goBoard.board[x][y-1] == allyPiece)){
            canBreathe = true;
        }
        else canBreathe = false;
        return canBreathe;
    }
}

