package ChessBoard;
import ChessPiece.*;


public class Player {
	private ChessPiece [] MyChessPieces;
	private String MyColor;
	private boolean myTurn;
	protected String myStatus;//"normal"/"checkmated"/"win"
	protected King myKing;
	
	public Player(String color) {
		// TODO Auto-generated constructor stub
		
		setMyColor(color);
		setMyTurn((color=="WHITE")?true: false);
		setMyChessPieces(new ChessPiece[16]);
		myStatus = "normal";
	}
	public Boolean checkChessPieceAccess( ChessPiece piece ){
		if (piece == null){
			System.out.print("Error : There is no chess piece here"); 
			return false;
		}
		else{
			if(piece.getColor()== this.getMyColor())
				return true;
			else
				return false;
			
		}
		
	}
	public ChessPiece [] getMyChessPieces() {
		return MyChessPieces;
	}
	public void setMyChessPieces(ChessPiece [] myChessPieces) {
		MyChessPieces = myChessPieces;
	}
	public boolean isMyTurn() {
		return myTurn;
	}
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}
	public String getMyColor() {
		return MyColor;
	}
	public void setMyColor(String myColor) {
		MyColor = myColor;
	}
}
