package pieceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessPiece.ChessPiece;
import ChessPiece.Knight;

public class KnightTest {

	@Test
	public void testMove() {
		CommonBoard testgame = new CommonBoard();
		ChessPiece knight = new Knight(4,4, "WHITE");
		testgame.getBoard()[4][4] = knight ;
		testgame.printBoard();
		
		assertTrue(testgame.moveChesspiece(knight, 3, 2));
		
		assertTrue(testgame.moveChesspiece(knight,2, 4));
		
		assertTrue(testgame.moveChesspiece(knight, 3, 6));
		
		assertTrue(testgame.moveChesspiece(knight, 4, 4));
		
		
		assertFalse(testgame.moveChesspiece(knight, 4, 3));
		assertFalse(testgame.moveChesspiece(knight, 5, 5));
		assertFalse(testgame.moveChesspiece(knight, 2, 2));
	}
}
