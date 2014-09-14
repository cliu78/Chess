package ChessPiece;

import ChessBoard.ChessBoard;

public class Pawn extends ChessPiece {

	public Pawn(int X, int Y, String color) {
		// TODO Auto-generated constructor stub
		super(X,Y, color);
	}
	
	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		if(targetrow== getPositionX() && targetcol == getPositionY())
			return null;
		if(targetcol == getPositionY()){
			//check is initial position
			if(isInitialPosition()){
				if( this.getColor() == "WHITE" ){
					switch(getPositionX() - targetrow){
					case 2:
						return "up2";
					case 1:
						return "up";
					
					default:
						return null;
						
					}
				}
				else{
					// color is black
					switch(targetrow -getPositionX() ){
					case 2:
						return "down2";
					case 1:
						return "down";
					
					default:
						return null;
						
					}
					
				}
				
			}
			else{
				
				if( 1==getPositionX() - targetrow )
					return "up";
				else
					return null;
			}
			
		}
		// check eat in diag square which must has enemy
		else if( chessBoard.getBoard()[targetrow][targetcol]!=null && chessBoard.getBoard()[targetrow][targetcol].getColor()!=this.getColor() ){
			//check whether go in front
			if( this.getColor()=="WHITE" && targetrow-getPositionX()==-1 && Math.abs(targetcol-getPositionY())==1 ){
				
				return (targetcol-getPositionY()==1)?"upright":"upleft";
			}
			else if( this.getColor()=="BLACK" && targetrow-getPositionX()==1 && Math.abs(targetcol-getPositionY())==1 ){
				
				return (targetcol-getPositionY()==1)?"downright":"downleft";
			}
		}
		return null;
	}

	private boolean isInitialPosition() {
		// TODO Auto-generated method stub
		return ( 1==this.getPositionX() && "BLACK"==this.getColor() ) || ( 6==this.getPositionX() && "WHITE"==this.getColor() );
	}
	
	public boolean checkPathObstacle(int targetrow, int targetcol, ChessBoard chessBoard, String direction) {
		// TODO Auto-generated method stub
		switch (direction){
		case "up":
		case "down":
			return false;
		case "up2":
			if(chessBoard.getBoard()[targetrow+1][targetcol]== null)
				return false;
			else
				return true;
		case "down2":
			if(chessBoard.getBoard()[targetrow-1][targetcol]== null)
				return false;
			else
				return true;
		case "upright":
		case "upleft":
		case "downleft":
		case "downright":
			return false;
		default:
			System.out.print("direction not defined");
			return true;
		}
		
	}
}
