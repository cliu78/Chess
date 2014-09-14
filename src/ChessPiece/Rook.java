package ChessPiece;

import ChessBoard.*;

public class Rook extends ChessPiece {

	public Rook(int X, int Y, String color) {
		// TODO Auto-generated constructor stub
		
		super(X, Y, color);
	}
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		// check path valid
		if( Math.abs(targetrow - getPositionX()) >0 && targetcol == getPositionY()){
			if(targetrow > getPositionX())
				return "down";
			else
				return "up";
		}
		else if( Math.abs(targetcol - getPositionY()) >0 && targetrow == getPositionX() ){
			if(targetcol > getPositionY())
				return "right";
			else
				return "left";
		}
		return null;
		
	}
	/***
	 * return true if there is a obstacle, false if the there is no obstacle
	 */
	 
	public boolean checkPathObstacle( int targetrow, int targetcol,ChessBoard chessboard, String direction ){
		int curx= this.getPositionX();
		int cury = this.getPositionY();
		
		while(curx!=targetrow || cury!= targetcol){
			if( (chessboard.getBoard()[curx][cury]!=null) && !( curx== this.getPositionX() && cury == this.getPositionY() ) )
				return true;
			switch (direction){
				case "left":
					cury--;
					break;
				case "right":
					cury ++;
					break;
				case "up":
					curx --;
					break;
				case "down":
					curx++;
					break;
					
				
			}
			
			
				
		}//while loop end
		
		
		return false;
	}
}
