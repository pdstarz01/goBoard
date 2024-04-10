public class Board {

    String board[][] = new String[9][9];
    static String empty = " + ";

    public void main(String[] args) {
        Create_Board();
    }
    public void Create_Board(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = empty;
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void Print_Board(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}