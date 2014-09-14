package ChessBoard;
import java.awt.Dimension;
import java.util.Stack;

import ChessPiece.ChessPiece;

public class ChessBoard {

	protected Dimension boardSize; 
	protected ChessPiece[][] board; 
	protected Stack<ChessPiece> eatenChessPieces ;
	private Player playerWhite;
	private Player playerBlack;
	private ChessPiece enemyKing;
	public ChessBoard() {
		
		

		// TODO Auto-generated constructor stub
		eatenChessPieces = new Stack<ChessPiece>();
		
		
	}
	
	
	
	public void SetChessStart(){
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isStalemate(Player player, Player enemyPlayer){
		if( ! isCheckmated(player, enemyPlayer)  ){
			int pKingX = player.myKing.getPositionX();
			int pKingY = player.myKing.getPositionY();
			
			
					
					
			boolean check1 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX+1, pKingY);
			boolean check2 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX-1, pKingY);
			boolean check3 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX+1, pKingY+1);
			boolean check4 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX+1, pKingY-1);
			boolean check5 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX-1, pKingY+1);
			boolean check6 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX-1, pKingY-1);
			boolean check7 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX, pKingY+1);
			boolean check8 = testIfMoveIsCheckmated(player, enemyPlayer, pKingX, pKingY-1);
			if( check1&&check2&&check3&&check4&&check5&&check6&&check7&&check8){
				player.myStatus = "win";
				enemyPlayer.myStatus = "win";
				System.out.print("Game End, it is a stalemate.");
				return true;
			}
				
		}
		
		return false;
	}



	private boolean testIfMoveIsCheckmated(Player player, Player enemyPlayer, int i, int j) {
		ChessPiece test = new ChessPiece(i, j ,player.getMyColor());
		ChessPiece old = this.board[i][j] ;
		this.board[i][j] = test;
		this.board[player.myKing.getPositionX()][player.myKing.getPositionY()]=null;
		if( ! isCheckmated(player, enemyPlayer) ){
			//put back
			this.board[i][j] = old;
			this.board[player.myKing.getPositionX()][player.myKing.getPositionY()]=player.myKing;
			test = null;
			return false;
		}
		this.board[i][j] = old;
		this.board[player.myKing.getPositionX()][player.myKing.getPositionY()]=player.myKing;
		test = null;
		return true;
	}
	
	public boolean isCheckmated( Player player , Player enemyPlayer ){
		if( check(player, enemyPlayer )  ){
			for(int i=0;i<player.getMyChessPieces().length;i++){
				if ( canBeSavedEach( player.getMyChessPieces()[i], player, enemyPlayer ) ){
					return false;
				}
			}
			
			player.myStatus = "checkmated";
			enemyPlayer.myStatus = "win";
			System.out.print("Game End, player" + enemyPlayer.getMyColor() + "wins.");
			return true;
		}
		
		return false;
		
	}
	
	
	
	public boolean check( Player player , Player enemyPlayer){
		// it is player's turn and it hasnot move chess yet
		for( int i = 0 ;i < enemyPlayer.getMyChessPieces().length ;i++  ){
			if ( isCheckmateEach(enemyPlayer.getMyChessPieces()[i]) ){
				//player is checked
				System.out.println("Player "+ player.getMyColor() + "is checked");
				return true;
			}
			
		}
		
		return false;
		
	}
	public boolean canBeSavedEach( ChessPiece piece, Player player, Player enemyPlayer ){
		for(int i = 0; i<8 ;i++){
			for(int j = 0 ;j<8;j++){
				String moveDir = piece.isMoveValid(i, j, this);
				if( moveDir !=null ){
					// is valid
					boolean retCheck = piece.checkPathObstacle(i, j, this,moveDir);
					if(retCheck == false){
						// can go there, test
						ChessPiece test = new ChessPiece(i,j,piece.getColor());
						ChessPiece old = this.board[i][j] ;
						this.board[i][j] = test;
						this.board[piece.getPositionX()][piece.getPositionY()]=null;
						if( ! check(player, enemyPlayer) ){
							//put back
							this.board[i][j] = old;
							this.board[piece.getPositionX()][piece.getPositionY()]=piece;
							test = null;
							return true;
						}
						this.board[i][j] = old;
						this.board[piece.getPositionX()][piece.getPositionY()]=piece;
						test = null;
						
					}
					
				}
				
				
			}
			
		}
		
		return false;
	}
	
	
	public boolean isCheckmateEach( ChessPiece piece  ){
		
		
		if(piece.getColor()=="WHITE"){
			ChessPiece enemyKing = this.playerBlack.myKing;
			String moveDir = piece.isMoveValid(enemyKing.getPositionX(), enemyKing.getPositionY(), this);
			if( moveDir !=null ){
				// is valid
				boolean retCheck = piece.checkPathObstacle(enemyKing.getPositionX(), enemyKing.getPositionY(), this,moveDir);
				if(retCheck == false)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else{
			ChessPiece enemyKing = this.playerWhite.getMyChessPieces()[3];
			String moveDir = piece.isMoveValid(enemyKing.getPositionX(), enemyKing.getPositionY(), this);
			if( moveDir !=null ){
				// is valid
				boolean retCheck = piece.checkPathObstacle(enemyKing.getPositionX(), enemyKing.getPositionY(), this,moveDir);
				if(retCheck == false)
					return true;
				else
					return false;
			}
			else
				return false;
		}
			
	}
	
	public ChessPiece getChessPiece(Player player, int row, int col){
		//check whether it is its turn
		if(player.isMyTurn()==false)
			return null;
		
		if( board[row][col] != null ){
			//check color
			if (player.checkChessPieceAccess(board[row][col])){
				return board[row][col];
			}
			else return null;
		}
		System.out.println("ChessBoard says: no chess piece at this point");
		return null;
	}

	public boolean moveChesspiece( ChessPiece piece, int targetrow, int targetcol  ){
		
		
		
		// basic logic
		
		if( (targetrow>7) || (targetrow<0) || (targetcol >7) || (targetcol <0) )
			return false;
		//check if it is itself
		if(targetrow == piece.getPositionX() && targetcol == piece.getPositionY())
			return false;
		//piece path valid check
		String direction = piece.isMoveValid(targetrow, targetcol, this);
		
		if( direction !=null ){
			// path is valid, but not sure there is no obstacle
			if(checkObstacle(piece, targetrow, targetcol, direction)){
				// there is obstacle
				return false;
			}
			// there is no obstacle:
			System.out.println("Chess piece"+ piece.getClass().getName() + " moves "+direction);
			ChessPiece target = board[targetrow][targetcol] ;
			int oldX = piece.getPositionX();
			int oldY = piece.getPositionY();
			
			if(target == null){
				// target is null directly move
				
				piece.movePiece(targetrow, targetcol);
				board[oldX][oldY] = null;
				board[targetrow][targetcol] = piece;
				return true;
			}
			else if( target.getColor() == piece.getColor()  ){
				//target is my piece, can not eat it
				return false;
				
			}
			else{
				// target is enemy , can eat it
				eatPiece(piece, target);
				board[oldX][oldY] = null;
				board[targetrow][targetcol] = piece;
				return true;
				
			}
		
		}
		
		else{
			System.out.print("ChessBoard says : srry can not move!");
			return false;
		}
	}
	
	private boolean checkObstacle(ChessPiece piece, int targetrow, int targetcol, String direction) {
		// TODO Auto-generated method stub
		
		return piece.checkPathObstacle(targetrow, targetcol, this, direction);
		
		
	}



	private void eatPiece(ChessPiece piece, ChessPiece target) {
		// TODO Auto-generated method stub
		eatenChessPieces.push(target);
		
		piece.movePiece(target.getPositionX(), target.getPositionY());
		
		
	}



	



	private boolean checkPositionAvailable(int targetrow, int targetcol) {
		// TODO Auto-generated method stub
		
		return false;
	}



	public ChessPiece[][] getBoard() {
		return board;
	}



	public void setBoard(ChessPiece[][] board) {
		this.board = board;
	}



	public Player getPlayerWhite() {
		return playerWhite;
	}



	public void setPlayerWhite(Player playerWhite) {
		this.playerWhite = playerWhite;
	}
	
	public void printBoard(){
		
	}
	
	public void changePlayerTurn(Player player1, Player player2){
		
		player1.setMyTurn(!(player1.isMyTurn()));
		player2.setMyTurn(!(player2.isMyTurn()));
		
	}



	public Player getPlayerBlack() {
		return playerBlack;
	}



	public void setPlayerBlack(Player playerBlack) {
		this.playerBlack = playerBlack;
	}
	
	
	public boolean removeChess(int targetrow, int targetcol ){
		
		if(board[targetrow][targetcol]==null)
			return false;
		else{
			ChessPiece rpiece= board[targetrow][targetcol];
			this.eatenChessPieces.add(rpiece);
			board[targetrow][targetcol]=null;
			this.printBoard();
			return true;
		}
			
	}
}
