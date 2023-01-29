import java.util.Random;
import java.util.Scanner;

interface Games{

    public boolean isGameFinished(char[][] board);
    public  boolean winning(char[][] board, char symbol);
    public  void computerTurn(char[][] board);
    public  boolean isValidMove (char[][] board, String position);
    public  void playerTurn(char[][] board, Scanner scanner);
    public  void placeMove(char[][] board, String position, char symbol);
    public  void printBoard(char[][] board);




}




public class Gamming implements Games {



	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String greencode = "\u001B[32m";
	public static final String green = "\u001B[32m";

	public static final String redCode = "\u001B[31m";
	public static final String red = "\u001B[31m";


	public static final String blueCOde = "\u001B[34m";
	public static final String blue = "\u001B[34m";





    public  boolean isGameFinished(char[][] board) {
		if (winning(board, 'X')) {	
			printBoard(board);
			System.out.println(green+"You Win!"+greencode);
			return true;
		}
		
		if (winning(board, 'O')) {	
			printBoard(board);
			System.out.println(red+"Computer wins!"+redCode);
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("Tied!");
		return true;
	}





	public  boolean winning(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}





	public  void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(board, Integer.toString(computerMove), 'O');
	}





	public  boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}


	
	public  void playerTurn(char[][] board, Scanner scanner) {
	

		
		String userInput;
		while (true) {
			System.out.println(ANSI_YELLOW+"Where would you like to play? (1-9)"+ ANSI_RESET);
		

			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)){
				break;
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, 'X');
	}

	




	public  void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	
	
	public  void printBoard(char[][] board) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("                                                   1 |  2 | 3                               "+board[0][0] + " | " +  board[0][1] + " | " +  board[0][2] );
		System.out.println("                                                   +-+-+-+-+-+                              +-+-+-+-+-+");
		System.out.println("                                                   4 |  5 | 6                               "+board[1][0] + " | " +  board[1][1] + " | " +  board[1][2] );
		System.out.println("                                                   +-+-+-+-+-+                              +-+-+-+-+-+");
		System.out.println("                                                   7 |  8 | 9                               "+board[2][0] + " | " +  board[2][1] + " | " +  board[2][2] );
	}






    
}
