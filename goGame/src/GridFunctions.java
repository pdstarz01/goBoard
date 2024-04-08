public class GridFunctions {

    String empty = " + ";

    public static String[][] visitedBoard(int boardWidth, int boardHeight){
        String[][] board = new String[boardWidth][boardHeight];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = " F ";
            }
        }
        return board;
    }
    public static void visitedPrint(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void singularCapture(Board goBoard, int x, int y){
        if(goBoard.board[x][y] == empty){
            if(((goBoard.board[x+1][y]) == (goBoard.board[x][y+1])) &&
            ((goBoard.board[x][y+1]) == (goBoard.board[x-1][y])) &&
            ((goBoard.board[x-1][y]) == (goBoard.board[x][y-1])) &&
            ((goBoard.board[x][y-1]) == (goBoard.board[x+1][y]))){
               System.out.println("all surrounding spaces are the same"); 
            }
        }
    }

    public boolean Can_Breathe(Board goBoard, int x, int y, String allyPiece){
        boolean canBreathe = true;
        if((goBoard.board[x+1][y] == empty) || (goBoard.board[x+1][y] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x][y+1] == empty) || (goBoard.board[x][y+1] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x-1][y] == empty) || (goBoard.board[x-1][y] == allyPiece)){
            canBreathe = true;
        }
        else if((goBoard.board[x][y-1] == empty) || (goBoard.board[x][y-1] == allyPiece)){
            canBreathe = true;
        }
        else canBreathe = false;
        return canBreathe;
    }
    //public static void 
    public static void main(String[] args) {
        String[][] b = visitedBoard(9,9);
        visitedPrint(b);
        System.out.println();
    }
}
