package ChessPiece;

import ChessBoard.ChessBoard;

public class Bishop extends ChessPiece {

	public Bishop(int X, int Y, String color) {
		// TODO Auto-generated constructor stub
		super(X, Y, color);
	}
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		if( Math.abs(targetrow - getPositionX()) == Math.abs(targetcol - getPositionY()) ){
			
			if( targetrow > getPositionX() ){
				// downwards
				if(targetcol > getPositionY()){
					return "downright";
				}
				else
					return "downleft";
			}
			else{
				// updwards
				if(targetcol > getPositionY()){
					return "upright";
				}
				else
					return "upleft";
				
			}
		}
		return null;
	}
	public boolean checkPathObstacle(int targetrow, int targetcol, ChessBoard chessBoard, String direction) {
		// TODO Auto-generated method stub
		int curx= this.getPositionX();
		int cury = this.getPositionY();
		
		while(curx!=targetrow || cury!= targetcol){
			if( (chessBoard.getBoard()[curx][cury]!=null) && !( curx== this.getPositionX() && cury == this.getPositionY() ) )
				return true;
			switch (direction){
				
				case "downright":
					curx++;
					cury++;
					break;
				case "downleft":
					curx++;
					cury--;
					break;
				case "upright":
					curx--;
					cury++;
					break;
				case "upleft":
					curx--;
					cury--;
					break;
				
				
			}
		}
		return false;
	}
}
