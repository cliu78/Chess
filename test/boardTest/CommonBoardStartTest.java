package boardTest;
import static org.junit.Assert.*;

import org.junit.Test;

import ChessBoard.CommonBoard;


public class CommonBoardStartTest {

	@Test
	public void SetStartTest() {
		CommonBoard  testboard= new CommonBoard();
		int i=0;
		
		
		String line =null ;
		String actualString = "BLACKclass ChessPiece.Rook  BLACKclass ChessPiece.Knight  BLACKclass ChessPiece.Bishop  BLACKclass ChessPiece.King  BLACKclass ChessPiece.Queen  BLACKclass ChessPiece.Bishop  BLACKclass ChessPiece.Knight  BLACKclass ChessPiece.Rook  ";
		checkEachline(testboard, i, actualString, line);
		
		i++;	
		line =null;
		actualString = "BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  BLACKclass ChessPiece.Pawn  ";
		checkEachline(testboard, i, actualString, line);
		for(i= 2 ; i< 6;i++){
			line =null ;
			actualString = "null  null  null  null  null  null  null  null  ";
			checkEachline(testboard, i, actualString, line);
		}
		
		line =null ;
		actualString = "WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  WHITEclass ChessPiece.Pawn  ";
		checkEachline(testboard, i, actualString, line);
		i++;
		line =null ;
		actualString = "WHITEclass ChessPiece.Rook  WHITEclass ChessPiece.Knight  WHITEclass ChessPiece.Bishop  WHITEclass ChessPiece.Queen  WHITEclass ChessPiece.King  WHITEclass ChessPiece.Bishop  WHITEclass ChessPiece.Knight  WHITEclass ChessPiece.Rook  ";
		checkEachline(testboard, i, actualString, line);
		
}
	
	private void checkEachline(CommonBoard testboard, int i, String actualString, String line) {
		if( testboard.getBoard()[i][0] != null)
			line = testboard.getBoard()[i][0].getColor() +testboard.getBoard()[i][0].getClass() + "  ";
		else
			line = testboard.getBoard()[i][0] +"  ";
		for(int j=1 ;j <8;j++){
			if(line ==null){
				if( testboard.getBoard()[i][j] != null)
					line = testboard.getBoard()[i][j].getColor() +testboard.getBoard()[i][j].getClass() + "  ";
				else
					line = testboard.getBoard()[i][j] +"  ";
			}
			if( testboard.getBoard()[i][j] != null)
				line = line +testboard.getBoard()[i][j].getColor() +testboard.getBoard()[i][j].getClass()+"  ";
			else
				line = line +testboard.getBoard()[i][j] +"  ";
		}
		
		assertEquals("should always black",line, actualString);
	}

}
