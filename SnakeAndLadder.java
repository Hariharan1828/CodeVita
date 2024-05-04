import java.util.*;

public class SnakeAndLadder {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);


        String[][] board = new String[10][10];
        for(int i=0;i<10;i++){
            for(int j=0; j<10;j++){
                board[i][j]= sc.next();
            }
        }

        int[] die = new int[10];
        for(int i=0;i<10;i++) {
            die[i] = sc.nextInt();
        }

        int SnakesEncountered=0;
        int laddersEncountered=0;
        int currentposition = 0;

         for(int i=0;i<10;i++){
             int dieInput = die[i];
             currentposition = simulatePlayerMovement(board, currentposition, dieInput);
             if(currentposition==-1){
                 System.out.println("Not Possible "+SnakesEncountered+" "+laddersEncountered);
                 return;
             }
             if (board[currentposition / 10][currentposition % 10].startsWith("S(")) {
                 SnakesEncountered++;
             } else if (board[currentposition / 10][currentposition % 10].startsWith("L(")) {
                 laddersEncountered++;
             }


         }
        System.out.println("Possible "+SnakesEncountered+" "+laddersEncountered);

    }

    private static int simulatePlayerMovement(String[][] board, int currentposition, int dieInput) {
        int row = currentposition / 10;
        int col = currentposition % 10;

        int newPosition = currentposition + dieInput;

        if (newPosition < 0 || newPosition > 99) {
            return -1; // Player cannot move outside the board
        }

        String cell = board[newPosition / 10][newPosition % 10];

        if (cell.startsWith("S(")) {
            int snakePosition = Integer.parseInt(cell.substring(2, cell.length() - 1));
            currentposition = snakePosition - 1; // -1 because the board is 0-based
        } else if (cell.startsWith("L(")) {
            int ladderPosition = Integer.parseInt(cell.substring(2, cell.length() - 1));
            currentposition = ladderPosition - 1; // -1 because the board is 0-based
        } else {
            currentposition += dieInput;
        }

        return currentposition;

    }
}
