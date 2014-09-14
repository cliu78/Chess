package ChessPiece;

import ChessBoard.ChessBoard;

public class Knight extends ChessPiece {

	public Knight(int X, int Y, String color) {
		// TODO Auto-generated constructor stub
		super(X,Y, color);
	}
	
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		if(Math.abs(targetrow- this.getPositionX())==1 && Math.abs(targetcol - this.getPositionY())==2)
			return "flat";
		if(Math.abs(targetrow- this.getPositionX())==2 && Math.abs(targetcol - this.getPositionY())==1)
			return "thin";
		
		return null;
	}
	public boolean checkPathObstacle( int targetrow, int targetcol,ChessBoard chessboard, String direction ){
		//always no obstacle
		return false;
	}
}
