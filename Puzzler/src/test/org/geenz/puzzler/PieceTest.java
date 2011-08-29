package org.geenz.puzzler;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {

	private final static Piece pieceC = new Piece(new char[][] {{ 'C', 'C' }, { '0', 'C' }, { '0', 'C' }, { '0', 'C' }});
	private final static Piece pieceK = new Piece(new char[][] {{ 'K', 'K' }, { 'K', 'K' }});
	private final static Piece pieceF = new Piece(new char[][] {{ 'F', 'F' }, { '0', 'F' }});
	
	@Before
	public void setUp() {
				
	}
	
	@Test
	public void testGetElementAt() {
		assertEquals('K', pieceK.getElementAt(0, 0));
	}
	
	@Test
	public void testGetEmptyElementAt() {
		assertEquals('0', pieceF.getElementAt(1, 0));
	}

	@Test
	public void testGetWidth() {
		assertEquals(2, pieceC.getWidth());
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(4, pieceC.getHeight());
	}
	
	@Test
	public void testGetHeightForTurnedOnceOrientation() {
		assertEquals(2, pieceC.getHeight(Piece.TURNED_90_DEGREES));
	}

	@Test
	public void testGetHeightForTurnedTwoTimesOrientation() {
		assertEquals(4, pieceC.getHeight(Piece.TURNED_180_DEGREES));
	}

	@Test
	public void testGetHeightForTurnedThreeTimesOrientation() {
		assertEquals(2, pieceC.getHeight(Piece.TURNED_270_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedOnceOrientation() {
		assertEquals(4, pieceC.getWidth(Piece.TURNED_90_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedTwoTimesOrientation() {
		assertEquals(2, pieceC.getWidth(Piece.TURNED_180_DEGREES));
	}

	@Test
	public void testGetWidthForTurnedThreeTimesOrientation() {
		assertEquals(4, pieceC.getWidth(Piece.TURNED_270_DEGREES));
	}

	@Test 
	public void testGetElementsForDefaultOrientation() {
		char[][] elements = pieceF.getElements(Piece.DEFAULT_ORIENTATION);
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('0', elements[1][0]);
		assertEquals('F', elements[1][1]);
		
	}
	
	@Test 
	public void testGetElementsForTurnedOnce() {
		char[][] elements = pieceF.getElements(Piece.TURNED_90_DEGREES);
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('F', elements[1][0]);
		assertEquals('0', elements[1][1]);		
	}

	@Test 
	public void testTurn() {
		char[][] elements = Piece.turn(pieceF.getElements());
		assertEquals('F', elements[0][0]);
		assertEquals('F', elements[0][1]);
		assertEquals('F', elements[1][0]);
		assertEquals('0', elements[1][1]);		
	}

	@Test
	public void testGetRightMosteElements() {
		char[] elements = Piece.getColumnOfArray(pieceF.getElements(), pieceF.getWidth() - 1);
		assertEquals('F', elements[0]);
		assertEquals('F', elements[1]);
	}
	
	@Test
	public void testGetNextColumn() {
		char[] elements = Piece.getColumnOfArray(pieceF.getElements(), pieceF.getWidth() - 2);
		assertEquals('F', elements[0]);
		assertEquals('0', elements[1]);		
	}
	
}
