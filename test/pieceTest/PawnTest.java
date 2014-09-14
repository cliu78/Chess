package pieceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessBoard.Player;
import ChessPiece.ChessPiece;

public class PawnTest {
	@Test
	public void testMove() {
		CommonBoard testgame = new CommonBoard();
		testgame.SetChessStart();
		testgame.printBoard();
		Player w = testgame.getPlayerWhite();
		Player b = testgame.getPlayerBlack();
		if(w.isMyTurn()){
			ChessPiece piece = testgame.getChessPiece(w, 6, 4);
			assertEquals("ChessPiece.Pawn" ,  piece.getClass().getName() );
			assertEquals(true , testgame.moveChesspiece(piece, 4, 4) );
			testgame.changePlayerTurn(w, b);
		}
		testgame.printBoard();
		
	}
}
