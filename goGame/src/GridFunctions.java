import java.util.ArrayList;

public class GridFunctions {

    static String empty = " + ";

    public static String[][] capturedBoard(int boardWidth, int boardHeight){
        String[][] board = new String[boardWidth][boardHeight];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = " F ";
            }
        }
        return board;
    }
    public static void capturedPrint(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static ArrayList<String> findNeighbors(String[][] board, int x, int y){
        ArrayList<String> neighbors = new ArrayList<String>();
        String U = "Up";
        String R = "Right";
        String D = "Down";
        String L = "Left";
        try{ if(board[x+1][y] != null){neighbors.add(R);} }
        catch(Exception e){}
        try{ if(board[x][y+1] != null){neighbors.add(D);} }
        catch(Exception e){}
        try{ if(board[x-1][y] != null){neighbors.add(L);} }
        catch(Exception e){}
        try{ if(board[x][y-1] != null){neighbors.add(U);} }
        catch(Exception e){}
        return neighbors;
    }
    public static void singularCapture(String[][] board, String[][] capturedBoard, int x, int y, Player a, Player b){
        String identity = "N/A";
        ArrayList<String> neighbors = findNeighbors(board, x, y);
        int size = neighbors.size();
        String[] neighborStrings = new String[size];
        if(capturedBoard[x][y] == " F "){
            if(board[x][y] == empty){
                for(int i = 0; i < size; i++){
                    if(neighbors.get(i) == "Right"){neighborStrings[i] = board[x+1][y];}
                    if(neighbors.get(i) == "Down"){neighborStrings[i] = board[x][y+1];}
                    if(neighbors.get(i) == "Left"){neighborStrings[i] = board[x-1][y];}
                    if(neighbors.get(i) == "Up"){neighborStrings[i] = board[x][y-1];}
                }
                for(int i = 0; i < neighborStrings.length; i++){
                    if(neighborStrings[0] == neighborStrings[i]){identity = neighborStrings[0];} 
                    else {
                        identity = "N/A";
                        break;
                    }
                }
                if(identity != "N/A"){
                    if(identity == empty){}
                    if(identity == a.piece){
                        a.points++;
                        capturedBoard[x][y] = " T ";
                    }
                    if(identity == b.piece){
                        b.points++;
                        capturedBoard[x][y] = " T ";
                    }
                }
            }
            if(board[x][y] == a.piece){
                for(int i = 0; i < size; i++){
                    if(neighbors.get(i) == "Right"){neighborStrings[i] = board[x+1][y];}
                    if(neighbors.get(i) == "Down"){neighborStrings[i] = board[x][y+1];}
                    if(neighbors.get(i) == "Left"){neighborStrings[i] = board[x-1][y];}
                    if(neighbors.get(i) == "Up"){neighborStrings[i] = board[x][y-1];}
                }
                for(int i = 0; i < neighborStrings.length; i++){
                    if(neighborStrings[0] == neighborStrings[i]){identity = neighborStrings[0];} 
                    else {
                        identity = "N/A";
                        break;
                    }
                }
                if(identity != "N/A"){
                    //System.out.println("we made it this far");
                    if(identity == empty){}
                    if(identity == a.piece){}
                    if(identity == b.piece){
                        b.points += 2;
                        board[x][y] = " + ";
                        capturedBoard[x][y] = " T ";
                    }
                }
            }
            if(board[x][y] == b.piece){
                for(int i = 0; i < size; i++){
                    if(neighbors.get(i) == "Right"){neighborStrings[i] = board[x+1][y];}
                    if(neighbors.get(i) == "Down"){neighborStrings[i] = board[x][y+1];}
                    if(neighbors.get(i) == "Left"){neighborStrings[i] = board[x-1][y];}
                    if(neighbors.get(i) == "Up"){neighborStrings[i] = board[x][y-1];}
                }
                for(int i = 0; i < neighborStrings.length; i++){
                    if(neighborStrings[0] == neighborStrings[i]){identity = neighborStrings[0];} 
                    else {
                        identity = "N/A";
                        break;
                    }
                }
                if(identity != "N/A"){
                    //System.out.println("we made it this far");
                    if(identity == empty){}
                    if(identity == a.piece){
                        a.points += 2;
                        board[x][y] = " + ";
                        capturedBoard[x][y] = " T ";
                    }
                    if(identity == b.piece){}
                }
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
        String[][] b = capturedBoard(9,9);
        capturedPrint(b);
        System.out.println();
    }
}
