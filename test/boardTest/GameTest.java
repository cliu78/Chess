/**
 * 
 */
package boardTest;

import java.util.Scanner;

import org.junit.Test;

import ChessBoard.CommonBoard;
import ChessBoard.Player;
import ChessPiece.ChessPiece;

/**
 * @author chenghao
 *
 */
public class GameTest {

	@Test
	public void test() {
		CommonBoard testgame = new CommonBoard();
		testgame.SetChessStart();
		Player b = testgame.getPlayerBlack();
		Player w = testgame.getPlayerWhite();
		
		
		testgame.printBoard();
		
		
		
		
		Scanner keyboard = new Scanner(System.in);
		Player cur = w ;
		while(true){
			
			System.out.println("It is "+ cur.getMyColor() + "\'s turn");
			Player enemy = (cur.getMyColor()== "WHITE")? b: w;
			if(testgame.isCheckmated(cur, enemy))
				break;
//			if(testgame.isStalemate(cur, enemy) )
//				break;
			System.out.println("enter an pos x");
			int pX = keyboard.nextInt();
			System.out.println("enter an pos y");
			int pY = keyboard.nextInt();
			ChessPiece piece = testgame.getChessPiece(cur, pX, pY);
			if(null == piece){
				System.out.println("Wrong ! try again");
				continue;
			}
			boolean ret =true;
			while(ret){
				System.out.println("enter where u wanna move-> pos x");
				pX = keyboard.nextInt();
				System.out.println("enter where u wanna move-> pos y");
				pY = keyboard.nextInt();
				ret = testgame.moveChesspiece(piece, pX, pY);
				if(ret){
					testgame.printBoard();
					testgame.changePlayerTurn(b, w);
					cur = (b.isMyTurn())? b:w;
					break;
				}
				else{
					System.out.println("Invalid target Try again");
					continue;
				}
				
			}
			
			
		}
		
		System.out.print("Game End");
	}

}
