package pieceTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessPiece.ChessPiece;
import ChessPiece.Rook;

public class RookTest {

	@Test
	public void test() {
		CommonBoard testgame = new CommonBoard();
		ChessPiece rook = new Rook(4,4, "WHITE");
		testgame.getBoard()[4][4] = rook ;
		testgame.printBoard();
		//up
		assertTrue(testgame.moveChesspiece(rook, 0, 4));
		//down
		assertTrue(testgame.moveChesspiece(rook, 7, 4));
		//left
		assertTrue(testgame.moveChesspiece(rook, 7, 2));
		//right
		assertTrue(testgame.moveChesspiece(rook, 7, 6));
	
	}

}
