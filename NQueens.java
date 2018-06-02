public class NQueens {
	

	public static void printBoard(int[] board){

		if (board.length==0)
			System.out.println("There is no solution");
		else // if board is not empty print it
		{
			for (int i=0;i<board.length;i++)
				for (int j=0;j<board.length;j++){
					if (j==board[i])
						System.out.print("Q");
					else
						System.out.print("*");
					if(j==board.length-1)
						System.out.println("");
					else
						System.out.print(" ");
				}
		}
		
	}

	public static boolean isLegalSolution(int[] board, int n){
		boolean output=true;
		if(board.length!=0){ 
			for(int i=0;i<board.length-1&output;i++)//run for every queen in the board except for the last
				for(int j=i+1;j<board.length&output;j++)//run for every queen in the rows below i
					if(board[j]==board[i]|board[j]-board[i]==j-i|board[j]-board[i]==i-j) // check if the queen in row j is in the same col or diagonal as the queen in row i
						output=false;
		}
		else
			if(n!=2&n!=3) //if board length is 0,check if number of queens matches
				output=false;
		return output;
	}
	public static boolean addQueen(int[] board, int row, int col){
		boolean output=true;
		for(int i=0;i<row&output;i++) // run for every queen in the partly solved board until the last solved row
			if(col==board[i]|col-board[i]==i-row|col-board[i]==row-i) // check if the queen in the same col of previous queens,or in the same diagonal
				output=false;
		if(output) // if the placement is valid, place the queen on the board
			board[row]=col;
		return output;
	}
	public static int[] nQueens(int n) {

		int[] board= new int[n];
		if (!nQueens(board,0,0)){ // if a solution for the board wasn't found, put an empty array in board
			int[] temp={};
			board=temp;
		}
		return board;

	}

	public static boolean nQueens(int[] board, int row, int col){

		boolean possible=false;
		if (row==board.length) // if reached past the last row solution is found.
			possible=true;
		else if (col==board.length) // if reached past the last col, queen couldn't be placed in the whole row
			possible=false;
			else {
				if(addQueen(board,row,col)) // if placing a queen in these row,col is possible puts a queen there
					possible=nQueens(board,row+1,0); // continue placing queens in the next row, if in the end a solution is found/not found, put true/false in possible
				if (!possible) // if the queen couldn't be placed in this row,col or a board solution for a queen in this place couldn't be found, continue to place a queen in the next col
					possible=nQueens(board,row,col+1);
			}
		
		return possible;

	}
}

	