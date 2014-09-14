package boardTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessBoard.Player;
import ChessPiece.ChessPiece;

public class CheckmatedTest {

	@Test
	public void test1() {
		CommonBoard testboard = new CommonBoard();
		testboard.SetChessStart();
		Player white = testboard.getPlayerWhite();
		Player black = testboard.getPlayerBlack();
		
		testboard.removeChess(6,4);
		testboard.removeChess(1,4);
		boolean status = testboard.isCheckmated(white, black);
		assertFalse( status  );
		
		testboard.removeChess(7,3);
		status = testboard.isCheckmated(white, black);
		assertEquals(false, status);
	}
	
	@Test
	public void test2(){
		// white should be checkmated as http://en.wikipedia.org/wiki/Fool%27s_mate
		CommonBoard testboard = new CommonBoard();
		testboard.SetChessStart();
		Player w = testboard.getPlayerWhite();
		Player b = testboard.getPlayerBlack();
//		b.getMyChessPieces()[3].setPositionX(4) ;
//		b.getMyChessPieces()[3].setPositionY(7) ;
//		testboard.getBoard()[4][7] = b.getMyChessPieces()[3];
//		testboard.getBoard()[0][3] = null;
		
		// Test get Chess Piece from the turn
		ChessPiece piece= testboard.getChessPiece(w, 6, 6);
		assertEquals( "ChessPiece.Pawn", piece.getClass().getName().toString() );
		
		//Test move style of "up2" of pawn
		boolean retStat = testboard.moveChesspiece(piece, 4, 6);
		assertTrue( retStat  );
		testboard.printBoard();
		
		
		//Test turn change
		testboard.changePlayerTurn(w, b);
		assertTrue(b.isMyTurn());
		assertFalse(w.isMyTurn());
		
		ChessPiece piece2 = testboard.getChessPiece(b, 1, 4);
		assertEquals( "ChessPiece.Pawn", piece2.getClass().getName().toString());
		retStat = testboard.moveChesspiece(piece2, 3, 4);
		assertTrue( retStat  );
		testboard.printBoard();
		
		
		testboard.changePlayerTurn(w, b);
		assertTrue(w.isMyTurn());
		assertFalse(b.isMyTurn());
		
		piece = testboard.getChessPiece(w, 6, 5);
		retStat = testboard.moveChesspiece(piece, 5, 5);
		assertTrue( retStat  );
		
		testboard.changePlayerTurn(w, b);
		boolean gameStat = testboard.isCheckmated(b, w);
		assertFalse( gameStat );
		
		//Test move path valid of QUEEN with "downright"
		piece = testboard.getChessPiece(b, 0, 3);
		assertEquals( "ChessPiece.Queen", piece.getClass().getName().toString());
		
		retStat = testboard.moveChesspiece(piece, 4, 7);
		assertTrue( retStat  );
		
		//change turn
		testboard.changePlayerTurn(w, b);
		assertTrue(w.isMyTurn());
		assertFalse(b.isMyTurn());
		gameStat = testboard.isCheckmated(w, b);
		assertFalse( gameStat );
		
	}
}
