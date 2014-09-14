package ChessPiece;

import ChessBoard.ChessBoard;

public class Queen extends ChessPiece {

	public Queen(int X, int Y, String color) {
		// TODO Auto-generated constructor stub
		super(X,Y, color);
	}
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		
		//check logic
		if( Math.abs(targetrow - getPositionX()) >0 && (targetcol == getPositionY())){
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
		else if( Math.abs(targetrow - getPositionX()) == Math.abs(targetcol - getPositionY()) ){
			
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
