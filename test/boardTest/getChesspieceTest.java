package boardTest;

import static org.junit.Assert.*;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessBoard.Player;
import ChessPiece.ChessPiece;

public class getChesspieceTest {

	@Test
	public void test() {
		CommonBoard testboard = new CommonBoard();
		Player white= testboard.getPlayerWhite();
		Player black= testboard.getPlayerBlack();
		ChessPiece piece = testboard.getChessPiece(white, 0, 0);
		assertEquals( piece, null  );
		ChessPiece piece0 = testboard.getChessPiece(white, 6, 0);// left most white rook
		assertEquals( piece0.getPositionX() , 6   );
		assertEquals( piece0.getPositionY() , 0   );
		assertEquals( piece0.getColor() , "WHITE"   );
		
		
		piece = testboard.getChessPiece(white, 7, 3);// white queen
		assertEquals( piece.getPositionX() , 7   );
		assertEquals( piece.getPositionY() , 3   );
		assertEquals( piece.getColor() , "WHITE"   );
		assertEquals("class ChessPiece.Queen", piece.getClass().toString()  );
		
		boolean retmove = testboard.moveChesspiece(piece, 5, 3);
		testboard.printBoard();
		assertEquals(false, retmove);
		retmove = testboard.moveChesspiece(piece0, 5, 0);
		assertEquals(true, retmove);
		
		
	}
	
	@Test
	public void test2(){
		
		
	} 

}
