package org.geenz.puzzler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {

	@Before
	public void setUp() {
				
	}
	
	@Test
	public void testGetElementAt() {
		assertEquals('K', Pieces.pieceK.getElementAt(0, 0));
	}
	
	@Test
	public void testGetEmptyElementAt() {
		assertEquals('0', Pieces.pieceF.getElementAt(1, 0));
	}

	@Test
	public void testGetWidth() {
		assertEquals(2, Pieces.pieceC.getWidth());
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(4, Pieces.pieceC.getHeight());
	}
	
	@Test
	public void testGetHeightForTurnedOnceOrientation() {
		assertEquals(2, Pieces.pieceC.getHeight(Piece.TURNED_90_DEGREES));
	}

	@Test
	public void testGetHeightForTurnedTwoTimesOrientation() {
		assertEquals(4, Pieces.pieceC.getHeight(Piece.TURNED_180_DEGREES));
	}

	@Test
	public void testGetHeightForTurnedThreeTimesOrientation() {
		assertEquals(2, Pieces.pieceC.getHeight(Piece.TURNED_270_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedOnceOrientation() {
		assertEquals(4, Pieces.pieceC.getWidth(Piece.TURNED_90_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedTwoTimesOrientation() {
		assertEquals(2, Pieces.pieceC.getWidth(Piece.TURNED_180_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedThreeTimesOrientation() {
		assertEquals(4, Pieces.pieceC.getWidth(Piece.TURNED_270_DEGREES));
	}

	@Test 
	public void testGetElementsForDefaultOrientation() {
		char[][] elements = Pieces.pieceF.getElements(Piece.DEFAULT_ORIENTATION);
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('0', elements[1][0]);
		assertEquals('F', elements[1][1]);
		
	}
	
	@Test 
	public void testGetElementsForTurnedOnce() {
		char[][] elements = Pieces.pieceF.getElements(Piece.TURNED_90_DEGREES);
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('F', elements[1][0]);
		assertEquals('0', elements[1][1]);		
	}

	@Test 
	public void testTurn() {
		char[][] elements = Piece.turn(Pieces.pieceF.getElements());
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('F', elements[1][0]);
		assertEquals('0', elements[1][1]);		
	}
	
	@Test
	public void testGetRightMosteElements() {
		char[] elements = Piece.getColumnOfArray(Pieces.pieceF.getElements(), Pieces.pieceF.getWidth() - 1);
		assertEquals('F', elements[0]);
		assertEquals('F', elements[1]);
	}
	
	@Test
	public void testGetNextColumn() {
		char[] elements = Piece.getColumnOfArray(Pieces.pieceF.getElements(), Pieces.pieceF.getWidth() - 2);
		assertEquals('F', elements[0]);
		assertEquals('0', elements[1]);		
	}

	@Test 
	public void testGetElementsForDefaultOrientationOfPieceC() {
		char[][] elements = Pieces.pieceC.getElements(Piece.DEFAULT_ORIENTATION);
		assertEquals('C', elements[0][0]);
		assertEquals('C', elements[0][1]);
		assertEquals('0', elements[1][0]);
		assertEquals('C', elements[1][1]);
		assertEquals('0', elements[2][0]);
		assertEquals('C', elements[2][1]);
		assertEquals('0', elements[3][0]);
		assertEquals('C', elements[3][1]);
	}
	
	@Test
	public void testReverseRow() {
		char[] elements = new char[] { '1', '2', '3' };
		char[] reversed = Piece.reverseRow(elements);
		assertEquals('3', reversed[0]);
		assertEquals('2', reversed[1]);
		assertEquals('1', reversed[2]);
	}
	
	@Test
	public void testFlip() {
		char[][] elements = Piece.flip(Pieces.pieceC.getElements());
		assertEquals('C', elements[0][0]);
		assertEquals('C', elements[0][1]);
		assertEquals('C', elements[1][0]);
		assertEquals('0', elements[1][1]);
		assertEquals('C', elements[2][0]);
		assertEquals('0', elements[2][1]);
		assertEquals('C', elements[3][0]);
		assertEquals('0', elements[3][1]);
	}
}
