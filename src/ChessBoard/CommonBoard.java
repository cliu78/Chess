package ChessBoard;

import java.awt.Dimension;

import ChessPiece.Bishop;
import ChessPiece.ChessPiece;
import ChessPiece.King;
import ChessPiece.Knight;
import ChessPiece.Pawn;
import ChessPiece.Queen;
import ChessPiece.Rook;

public class CommonBoard extends ChessBoard {
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BLACK = "\u001B[30m";
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_GREEN = "\u001B[32m";

	public CommonBoard() {
		// TODO Auto-generated constructor stub
		super();
		int width = 8;
		int height = 8;
		Dimension boardSize = new Dimension(width, height);// used for GUI
		setBoard(new ChessPiece [width][height]);
		
		//SetChessStart();   --- this is for demo delete it in real game
		printBoard();
	}
	
	
	public void  printBoard(){
		System.out.println("Board:\n\n");
		for(int i= 0 ; i< 8;i++){
			
			for(int j=0 ;j <8;j++){
				if( getBoard()[i][j] != null){
					String pieceStyle = getBoard()[i][j].getClass().getName();
					String pieceColor = getBoard()[i][j].getColor();
					String prints =pieceColor.substring(0, 2) + pieceStyle.substring(pieceStyle.lastIndexOf('.') + 1).substring(0, 2) ;
					System.out.print( prints +"  ");
				}
				else
					System.out.print(getBoard()[i][j] +"  ");
			}
			System.out.println();
		}
		
	}
	
	public void SetChessStart(){
		setPlayerWhite(new Player("WHITE"));
		setPlayerBlack(new Player("BLACK"));
		
		 
		 int line = 7;
		 
		getBoard()[line][0] = new Rook(line,0,getPlayerWhite().getMyColor() );
		 getBoard()[line][1] = new Knight(line,1, getPlayerWhite().getMyColor() );
		 getBoard()[line][2] = new Bishop(line,2,getPlayerWhite().getMyColor());
		 getBoard()[line][3] = new Queen(line,3,getPlayerWhite().getMyColor());
		 King kingw = new King(line, 4,getPlayerWhite().getMyColor());
		 getBoard()[line][4] = kingw ;
		 getBoard()[line][5] = new Bishop(line,5,getPlayerWhite().getMyColor());
		 getBoard()[line][6] = new Knight(line,6,getPlayerWhite().getMyColor());
		 getBoard()[line][7] = new Rook(line,line,getPlayerWhite().getMyColor());
		 
		 this.getPlayerWhite().getMyChessPieces()[0] =getBoard()[line][0];
		 this.getPlayerWhite().getMyChessPieces()[1] =getBoard()[line][1];
		 this.getPlayerWhite().getMyChessPieces()[2] =getBoard()[line][2];
		 this.getPlayerWhite().getMyChessPieces()[3] =getBoard()[line][3];
		 this.getPlayerWhite().getMyChessPieces()[4] = getBoard()[line][4];
		 this.getPlayerWhite().getMyChessPieces()[5] = getBoard()[line][5];
		 this.getPlayerWhite().getMyChessPieces()[6] = getBoard()[line][6];
		 this.getPlayerWhite().getMyChessPieces()[7] = getBoard()[line][7];
		 this.getPlayerWhite().myKing= kingw;
		 
		 line = 6;
		 for(int i = 0 ;i< 8;i++){
			 getBoard()[line][i] = new Pawn(line, i, getPlayerWhite().getMyColor());
			 this.getPlayerWhite().getMyChessPieces()[8+i] = getBoard()[line][i];
		 }
		 
		 line = 0;
		 getBoard()[line][0] = new Rook(line,0,getPlayerBlack().getMyColor() );
		 getBoard()[line][1] = new Knight(line,1, getPlayerBlack().getMyColor() );
		 getBoard()[line][2] = new Bishop(line,2,getPlayerBlack().getMyColor());
		 getBoard()[line][3] = new Queen(line, 3,getPlayerBlack().getMyColor());
		 King kingb = new King(line,4,getPlayerBlack().getMyColor());
		 getBoard()[line][4] = kingb;
		 getBoard()[line][5] = new Bishop(line,5,getPlayerBlack().getMyColor());
		 getBoard()[line][6] = new Knight(line,6,getPlayerBlack().getMyColor());
		 getBoard()[line][7] = new Rook(line,line,getPlayerBlack().getMyColor());
		 
		 this.getPlayerBlack().getMyChessPieces()[0] = getBoard()[line][0];
		 this.getPlayerBlack().getMyChessPieces()[1] = getBoard()[line][1];
		 this.getPlayerBlack().getMyChessPieces()[2] = getBoard()[line][2];
		 this.getPlayerBlack().getMyChessPieces()[3] = getBoard()[line][3];
		 this.getPlayerBlack().getMyChessPieces()[4] = getBoard()[line][4];
		 this.getPlayerBlack().getMyChessPieces()[5] = getBoard()[line][5];
		 this.getPlayerBlack().getMyChessPieces()[6] = getBoard()[line][6];
		 this.getPlayerBlack().getMyChessPieces()[7] = getBoard()[line][7];
		 this.getPlayerBlack().myKing = kingb;
		 
		 line = 1;
		 for(int i = 0 ;i< 8;i++){
			 getBoard()[line][i] = new Pawn(line, i, getPlayerBlack().getMyColor());
			 this.getPlayerBlack().getMyChessPieces()[8+i] = getBoard()[line][i];
			 
		 }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBoard theboard = new CommonBoard();
		theboard.SetChessStart();
	}
	
}
