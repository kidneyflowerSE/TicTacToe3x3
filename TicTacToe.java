import java.util.Scanner;

public class TicTacToe {
    private static final char EMTY = '_';
    private static char PLAYER_X = 'X';
    private static char PLAYER_O = 'O';
    private static char[][] board = new char[3][3]; 
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = EMTY;
            }
        }
    }
    private static void printBoard(){
        System.out.println("Current Board");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
               System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playGame(){
        boolean gameWon = false;
        boolean isDraw =  false;

        while (!isDraw && !gameWon) {
            printBoard();
            playerMove();

            gameWon = checkWin();
            isDraw = checkDraw();

            if(!gameWon && !isDraw) {
                switchPlayer();
            }
        }

        printBoard();

        if (gameWon){
            System.out.println("Player " + currentPlayer + " win");
        } else if (isDraw) {
            System.out.println("Draw");
        }
    }

    
    private static void playerMove(){
        Scanner sc = new Scanner(System.in);
        int row, col;

        while(true){
            System.out.println("Player " + currentPlayer + ", enter your move (row and collumn)");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;

            if(row >= 0 && row < 3 && col >=0 && col < 3 && board[row][col] == EMTY){
                board[row][col] = currentPlayer;
                break;
            }
            else System.out.println("Error");
        }
    }

    private static void switchPlayer(){
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private static boolean checkWin(){
        return (checkRow() || checkColumns() || checkDiagonals());
    }

    private static boolean checkRow(){
        for(int i = 0; i < 3; i++){
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer){
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns(){
        for(int i = 0; i < 3; i++){
            if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals(){
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
        (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean checkDraw(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == EMTY) 
                    return false;
            }
        }
        return true;
    }
}