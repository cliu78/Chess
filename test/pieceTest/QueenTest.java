package pieceTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessPiece.Queen;

public class QueenTest {

	@Test
	public void testMove() {
		CommonBoard testgame = new CommonBoard();
		Queen queen = new Queen(4,4, "WHITE");
		testgame.getBoard()[4][4] = queen ;
		testgame.printBoard();
		//up
		assertTrue(testgame.moveChesspiece(queen, 3, 4));
		//down
		assertTrue(testgame.moveChesspiece(queen, 4, 4));
		//left
		assertTrue(testgame.moveChesspiece(queen, 4, 3));
		//right
		assertTrue(testgame.moveChesspiece(queen, 4, 4));
	}

}
