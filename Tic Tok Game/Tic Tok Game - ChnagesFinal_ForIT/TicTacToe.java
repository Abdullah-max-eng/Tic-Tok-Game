import java.util.Random;
import java.util.Scanner;


public class TicTacToe {

	public static void main(String[] args) {


		Games newObject = GamminFactory.getObject();


		Scanner scanner = new Scanner(System.in);
		
		char[][] board = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		newObject.printBoard(board);
		
		
		while (true) {
			newObject.playerTurn(board, scanner);
			if (newObject.isGameFinished(board)){
				break;
			}
			newObject.printBoard(board);
			
			newObject.computerTurn(board);
			if (newObject.isGameFinished(board)){
				break;
			}
			newObject.printBoard(board);
		}
		scanner.close();
	}


		
}
  