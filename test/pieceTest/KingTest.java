package pieceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessBoard.Player;
import ChessPiece.ChessPiece;
import ChessPiece.King;

public class KingTest {
	
	@Test
	public void testGet(){
		CommonBoard testgame = new CommonBoard();
		testgame.SetChessStart();
		Player b = testgame.getPlayerBlack();
		ChessPiece piece = testgame.getChessPiece(b, 6, 4);
		assertEquals(null, piece);
		
		Player w = testgame.getPlayerWhite();
		piece = testgame.getChessPiece(w, 7, 4);
		assertEquals("class ChessPiece.King", piece.getClass().toString() );
	}
	
	@Test
	public void testMove() {
		CommonBoard testgame = new CommonBoard();
		King king = new King(4,4, "WHITE");
		testgame.getBoard()[4][4] = king ;
		
		//up
		assertTrue(testgame.moveChesspiece(king, 3, 4));
		//down
		assertTrue(testgame.moveChesspiece(king, 4, 4));
		//left
		assertTrue(testgame.moveChesspiece(king, 4, 3));
		//right
		assertTrue(testgame.moveChesspiece(king, 4, 4));
	}
	
}
