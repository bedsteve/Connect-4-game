import java.util.Objects;
import java.util.Scanner;

public class Connect_4 {
    //🔴 🟡

    public static String checkWinner(String[][] board) {
        // row check
        String previous_string = "";
        int red_count = 0;
        int yellow_count = 0;
        for(String[] row : board) {
            for(String col : row) {

                if(!col.equals(previous_string)) {
                    previous_string = col;
                    red_count = 0;
                    yellow_count = 0;

                }
                if (col.equals("🔴")) {
                    red_count++;
                    if(red_count == 4) {return "🔴";}

                } else if (col.equals("🟡")) {
                    yellow_count++;
                    if (yellow_count == 4) {return "🟡";}
                }
            }




        }
        // Column check

        red_count = 0;
        yellow_count = 0;
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (!board[row][col].equals(previous_string)) {
                    previous_string = board[row][col];
                    red_count = 0;
                    yellow_count = 0;
                }
                if (board[row][col].equals("🔴")) {
                    red_count++;
                    if (red_count == 4) {
                        return "🔴";
                    }

                } else if (board[row][col].equals("🟡")) {
                    yellow_count++;
                    if (yellow_count == 4) {
                        return "🟡";
                    }
                }
            }
        }
        //Minor diagonal check
        red_count = 0;
        yellow_count = 0;
        previous_string = " ";
        int row = 0;

        for (int col = 0; col < board.length; col++) {

            if (!board[row][col].equals(previous_string)) {
                previous_string = board[row][col];
                red_count = 0;
                yellow_count = 0;
            }
            if (board[row][col].equals("🔴")) {
                red_count++;
                if (red_count == 4) {
                    return "🔴";
                }

            } else if (board[row][col].equals("🟡")) {
                yellow_count++;
                if (yellow_count == 4) {
                    return "🟡";
                }
            }
            row++;
        }
        //Major diagonal check
        red_count = 0;
        yellow_count = 0;
        previous_string = " ";
        row = 0;

        for (int col = board.length; col > 0; col--) {

            if (!board[row][col].equals(previous_string)) {
                previous_string = board[row][col];
                red_count = 0;
                yellow_count = 0;
            }
            if (board[row][col].equals("🔴")) {
                red_count++;
                if (red_count == 4) {
                    return "🔴";
                }

            } else if (board[row][col].equals("🟡")) {
                yellow_count++;
                if (yellow_count == 4) {
                    return "🟡";
                }
            }
            row++;
        }





        //checks if it's full
        int count = 0;
        for (String[] row_var : board) {
            for(String col : row_var) {
                if (!col.equals("  ")) {
                    count++;
                } else {
                    break;
                }
            }
        }
        if (count != 6 * 7) {
            return "Full";
        }

        return "None";



    }

    public static void printBoard(String[][] board) {

        for (String[] row : board) {
            for (String col : row) {
                System.out.print("|"+col);
            }
            System.out.println("|");
        }
        System.out.println("------------------------------");

    }
    //🔴 🟡



    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);

        String[][] game_board = new String[6][7];
        for(int r = 0; r < game_board.length; r++){
            for (int c = 0; c < game_board[r].length; c++) {
               game_board[r][c] = "  ";
            }
        }
        // print board
        printBoard(game_board);

        //Set the players turn
        int turn  = 1;
        int column = 0;
        boolean playerWon = false;


        while (!playerWon) {

            if (turn == 1) {
                System.out.println("Player 1 drop your red disk at column");
                column  = answer.nextInt();
                for(int row = game_board.length - 1; row >= 0; row--) {
                    if(game_board[row][column].equals("  ")) {
                        game_board[row][column] = "\uD83D\uDD34";
                        break;
                    }
                }

            } else {
                System.out.println("Player 2 drop your yellow disk at column");
                column  = answer.nextInt();
                for(int row = game_board.length - 1; row >= 0; row--) {
                    if(game_board[row][column].equals("  ")) {
                        game_board[row][column] = "\uD83D\uDFE1";
                        break;
                    }
                }
            }
            printBoard(game_board);


            if (checkWinner(game_board).equals("\uD83D\uDFE1")) {
                System.out.println("Player 2 won");
                playerWon = true;
            } else if (checkWinner(game_board).equals("\uD83D\uDD34")) {
                System.out.println("Player 1 won");
                playerWon = true;

            } else if (checkWinner(game_board).equals("Full")) {
                System.out.println("This a tie");
            } else if (checkWinner(game_board).equals("None")) {
                if (turn == 1) {
                    turn = 2;
                } else{
                    turn = 1;
                }
            }


        }

    }
}
