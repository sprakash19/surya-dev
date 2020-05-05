import java.util.Random;
import java.util.Scanner;

public class Connect4 {
	final static int p1Value = 1;
	final static int p2Value = 2;

	public static void main(String[] args) {
		Connect4 obj = new Connect4();
		int[][] board = new int[4][4];
		int col = 0;
		int i = 0;
		int win = 0;

		obj.printBoard(board);
		while (win == 0) {

			col = getInput(i % 2);
			if (col == -1) {
				continue;
			}
			// col = getRandomNumberInRange(0,3);
			win = obj.playBoard(board, i % 2 == 0 ? p1Value : p2Value, col - 1);
			if (win == -1) {
				win = 0;
				continue;
			}
			obj.printBoard(board);
			i++;
			if (i == 15) {
				break;
			}
		}

		obj.printBoard(board);

		System.out.println(win == 1 ? (i % 2 == 1 ? "Player 1 Wins" : "Player 2 Wins") : "No Result");

	}

	private static int getInput(int x) {

		System.out.println((x == 0 ? "Player 1 " : "Player 2 ") + "(Enter column number 1 to 4 to place coin):");

		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		if (col < 1 || col > 4) {
			System.out.println("Please enter valid Column between 1 and 4");
			return -1;
		}
		return col;
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	private void printBoard(int[][] board) {
		for (int k = 0; k < board.length; k++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print("|"+board[k][j]);
				if(j == board[0].length-1) {
					System.out.print("|");	
				}
			}
			if(k == board.length-1) {
				System.out.println();
				System.out.print("---------");	
			}
			
			System.out.println();
		}
		
		System.out.println();

	}

	private int playBoard(int[][] board, int playerValue, int col) {

		int rowLength = board.length;
		int rowToPlace = rowLength - 1;
		while (rowToPlace > -1 && (board[rowToPlace][col] == p1Value || board[rowToPlace][col] == p2Value)) {
			rowToPlace--;
		}
		if (rowToPlace < 0) {
			System.out.println("Please choose another column");
			return -1;
		}
		board[rowToPlace][col] = playerValue;

		return isConnect4(board, playerValue, rowToPlace, col);

	}

	private int isConnect4(int[][] board, int playerValue, int placedRow, int placedCol) {

		int currRow = placedRow;
		int currCol = placedCol + 1;
		int count = 0;
		// horizontal
		// increment
		while (currCol < board.length) {
			if (board[placedRow][currCol] == playerValue) {
				count++;
				currCol++;
				if (count == 4) {
					return 1;
				}
			} else if (board[placedRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		// decrement

		currCol = placedCol;

		while (currCol >= 0) {
			if (board[placedRow][currCol] == playerValue) {
				count++;
				currCol--;
				if (count == 4) {
					return 1;
				}
			} else if (board[placedRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		// vertical
		currRow = placedRow + 1;

		count = 0;

		while (currRow < board.length) {
			if (board[currRow][placedCol] == playerValue) {
				count++;
				currRow++;
				if (count == 4) {
					return 1;
				}
			} else if (board[currRow][placedCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		// decrement
		currRow = placedRow;

		while (currRow >= 0) {
			if (board[currRow][placedCol] == playerValue) {
				count++;
				currRow--;
				if (count == 4) {
					return 1;
				}
			} else if (board[currRow][placedCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		// diagonal left to right

		currRow = placedRow + 1;
		currCol = placedCol + 1;
		count = 0;
		// col inc, row inc
		while (currRow < board.length && currCol < board[0].length) {
			if (board[currRow][currCol] == playerValue) {
				count++;
				currRow++;
				currCol++;
			} else if (board[currRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}
		// col dec, row dec
		currRow = placedRow;
		currCol = placedCol;
		// decrement
		while (currRow >= 0 && currCol >= 0) {
			if (board[currRow][currCol] == playerValue) {
				count++;
				currRow--;
				currCol--;
			} else if (board[currRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		// Diagonal right to left
		// col inc, row dec
		currRow = placedRow - 1;
		currCol = placedCol + 1;
		count = 0;

		while (currRow >= 0 && currCol < board[0].length) {
			if (board[currRow][currCol] == playerValue) {
				count++;
				currRow--;
				currCol++;
			} else if (board[currRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}
		// col dec, row inc
		currRow = placedRow;
		currCol = placedCol;

		while (currRow < board.length && currCol >= 0) {
			if (board[currRow][currCol] == playerValue) {
				count++;
				currRow++;
				currCol--;
			} else if (board[currRow][currCol] != playerValue) {
				break;
			}
		}
		if (count == 4) {
			return 1;
		}

		return 0;
	}

}
