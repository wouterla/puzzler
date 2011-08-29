package org.geenz.puzzler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {

	private Piece piece_of_one = new Piece(new char[][] {{ 'C' }});
	private Piece piece_of_two = new Piece(new char[][] {{ 'C', 'C' }});
	private Piece pieceC = new Piece(new char[][] {{ 'C', 'C' }, { '0', 'C' }, { '0', 'C' }, { '0', 'C' }});


	Grid grid = null;
	
	@Before
	public void initializeGrid() {
		grid = new Grid();
		grid.fillWith('Z');
	}
	
	@Test
	public void testDetectEmptyPlace() {
		grid.setValueAt(2, 3, Grid.EMPTY);
		assertTrue(grid.hasEmptyPlace());
		grid.print();
	}
	
	@Test
	public void testFindEmptyPlace() {
		grid.setValueAt(2, 3, Grid.EMPTY);
		assertEquals(new Coordinate(2, 3), grid.findEmptyPlace());
		grid.print();		
	}

	@Test
	public void testFindAllEmptyPlaces() {
		grid.setValueAt(2, 3, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		grid.setValueAt(10, 1, Grid.EMPTY);
		List<Coordinate> coords = grid.getAllEmptyPlaces();
		assertTrue(coords.contains(new Coordinate(2, 3)));
		assertTrue(coords.contains(new Coordinate(3, 3)));
		assertTrue(coords.contains(new Coordinate(10, 1)));
		assertEquals(3, coords.size());
	}
	
	@Test
	public void testFindEmptyPlaceForPieceOfTwo() {
		grid.setValueAt(2, 3, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		assertTrue(grid.findPlaceFor(piece_of_two));
		grid.print();
	}

	@Test
	public void testFindEmptyPlaceForRotatedPieceOfTwo() {
		grid.setValueAt(3, 2, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		assertTrue(grid.findPlaceFor(piece_of_two));
		grid.print();
	}

	@Test
	public void testFindEmplyPlaceForCPiece() {
		grid.setValueAt(3, 2, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		grid.setValueAt(4, 3, Grid.EMPTY);
		grid.setValueAt(5, 3, Grid.EMPTY);
		grid.setValueAt(6, 3, Grid.EMPTY);
		grid.print();
		assertTrue(grid.findPlaceFor(Pieces.pieceC));
		grid.print();
	}
	
	@Test
	public void testFindCorrectPieceToPlace() {
		grid.setValueAt(3, 2, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		grid.setValueAt(4, 3, Grid.EMPTY);		
		grid.print();
		Piece p = grid.findFittingPiece(Pieces.pieces);
		grid.print();
		assertEquals(Pieces.pieceF, p);		
	}

	@Test
	public void testFindMultipleCorrectPiecesToPlace() {
		grid.setValueAt(3, 2, Grid.EMPTY);
		grid.setValueAt(3, 3, Grid.EMPTY);
		grid.setValueAt(4, 3, Grid.EMPTY);		
		grid.setValueAt(5, 3, Grid.EMPTY);		
		grid.setValueAt(6, 3, Grid.EMPTY);		
		grid.print();
		List<PlacedPiece> p = grid.findFittingPieces(Pieces.pieces);
		assertEquals(4, p.size());
		for (PlacedPiece placedPiece : p) {
			Piece f = placedPiece.getPiece();
			assertTrue(f.equals(Pieces.pieceA)
				|| f.equals(Pieces.pieceC)
				|| f.equals(Pieces.pieceF)
				|| f.equals(Pieces.pieceJ));
		}
	}
}
