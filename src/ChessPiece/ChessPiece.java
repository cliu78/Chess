package ChessPiece;

import ChessBoard.ChessBoard;

public class ChessPiece {
	
	private int positionX ;
	private int positionY;
	protected String color;
	
	public ChessPiece(int x, int y, String playercolor) {
		// TODO Auto-generated constructor stub
		setPositionX(x);
		setPositionY(y);
		color = playercolor;
	}
	
	public String getColor(){
		if (color != null)
			return color;
		else 
			return null;
	}

	public String isMoveValid(int targetrow, int targetcol, ChessBoard chessBoard) {
		// TODO Auto-generated method stub
		return null;
	}

	public void movePiece(int targetrow, int targetcol) {
		// TODO Auto-generated method stub
		setPositionX(targetrow);
		setPositionY(targetcol);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean checkPathObstacle(int targetrow, int targetcol, ChessBoard chessBoard, String direction) {
		// TODO Auto-generated method stub
		return true;
	}

}
