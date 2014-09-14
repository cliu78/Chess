package ChessPiece;

import ChessBoard.ChessBoard;
import ChessBoard.CommonBoard;

public class King extends ChessPiece {
	
	
	
	
	public King( int X, int Y, String color ) {
		// TODO Auto-generated constructor stub
		super(X, Y, color);
		
		
	}
	
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		
		if(Math.abs(targetrow - getPositionX())<=1 && Math.abs(targetcol - getPositionY())<=1)
			return "all";
		else
			return null;
	}
	
	public boolean checkPathObstacle( int targetrow, int targetcol,ChessBoard chessboard, String direction ){
		//always no obstacle

		return false;
	}
	
}
