package org.geenz.puzzler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PuzzlerGridTest {

	Grid grid = null;
	
	@Before
	public void setUp() {
		grid = new Grid();
	}
	
	@Test
	public void testGridIsFiveHigh() {
		assertEquals(5, grid.getHeight());
	}

	@Test
	public void testGridIsElevenWide() {
		assertEquals(11, grid.getWidth());
	}
	
	@Test
	public void testGridBaseIsEmpty() {
		assertFalse(grid.isFilled(1, 1));
	}

	@Test
	public void testGridBaseIsFilled() {
		grid.fillWith(1, 2, 'F');
		assertTrue(grid.isFilled(1, 2));
	}
	
	@Test
	public void testSetSingleCoordinate() {
		grid.fillWith(1, 2, 'F');
		assertTrue(grid.isFilled(1, 2));
	}
	
	@Test
	public void testFillWithPiece() {
		Piece piece = new Piece(new char[][] {{ 'K', 'K' }, { 'K', 'K' }});
		grid.place(0, 0, piece);
		assertTrue(grid.isFilled(0, 0));
		assertTrue(grid.isFilled(1, 0));
		assertTrue(grid.isFilled(0, 1));
		assertTrue(grid.isFilled(1, 1));
	}

	@Test
	public void testValueAt() {
		Piece piece = new Piece(new char[][] {{ 'A', 'B', 'C' }, { 'D', 'E', 'F' }});
		grid.place(2, 1, piece);
		assertEquals('A', grid.valueAt(2, 1));
		assertEquals('B', grid.valueAt(3, 1));
		assertEquals('C', grid.valueAt(4, 1));
		assertEquals('D', grid.valueAt(2, 2));
		assertEquals('E', grid.valueAt(3, 2));
		assertEquals('F', grid.valueAt(4, 2));
	}
	
	@Test
	public void testPlaceWithOrientation() {
		Piece piece = new Piece(new char[][] {{ 'A', 'B', 'C' }, { 'D', 'E', 'F' }});
		grid.place(2, 1, piece, Piece.TURNED_180_DEGREES);
		assertEquals('F', grid.valueAt(2, 1));
		assertEquals('E', grid.valueAt(3, 1));
		assertEquals('D', grid.valueAt(4, 1));
		assertEquals('C', grid.valueAt(2, 2));
		assertEquals('B', grid.valueAt(3, 2));
		assertEquals('A', grid.valueAt(4, 2));	
	}
}
