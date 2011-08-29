package org.geenz.puzzler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Grid {

	protected static final char EMPTY = '0';
	protected static final int NO_FIT = -1;

	protected static final int GRID_WIDTH = 11;
	protected static final int GRID_HEIGHT = 5;
	
	private char[][] grid = new char[GRID_WIDTH][GRID_HEIGHT];
	
	public Grid() {
		fillWith(EMPTY);		
	}

	protected void fillWith(char value) {
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], value);	
		}
	}
	
	public int getHeight() {
		return GRID_HEIGHT;
	}

	public int getWidth() {
		return GRID_WIDTH;
	}

	public boolean isFilled(int i, int j) {
		return grid[i][j] != EMPTY;
	}

	public void fillWith(int i, int j, char value) {
		grid[i][j] = value;
	}

	public void place(int i, int j, Piece piece) {
		place(i, j, piece, Piece.DEFAULT_ORIENTATION);
	}

	public char valueAt(int i, int j) {
		return grid[i][j];
	}

	protected void setValueAt(int i, int j, char value) {
		grid[i][j] = value;
	}

	public void place(int i, int j, Piece piece, int orientation) {
		for (int k = 0; k < piece.getWidth(orientation); k++) {
			for (int l = 0; l < piece.getHeight(orientation); l++) {
				char value = piece.getElementAt(l, k, orientation);
				if (value != EMPTY) {
					fillWith(i + k, j + l, value);
				}
			}
		}
	}
	
	public void print() {
		for (int j = getHeight() - 1; j >= 0; j--) {
			for (int i = 0; i < getWidth(); i++) {
				System.out.print(valueAt(i, j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean findPlaceFor(Piece piece) {		
		List<Coordinate> emptyPlaces = getAllEmptyPlaces();
		for (Coordinate coordinate : emptyPlaces) {
			int orientation = fits(piece, coordinate); 
			if (NO_FIT != orientation) {
				place(coordinate.getX(), coordinate.getY(), piece, orientation);
				return true;
			}
		}
		return false;
	}
	
	public List<PlacedPiece> findPlacesFor(Piece piece) {
		List<PlacedPiece> foundPlaces = new ArrayList<PlacedPiece>(); 
		List<Coordinate> emptyPlaces = getAllEmptyPlaces();
		for (Coordinate coordinate : emptyPlaces) {
			int orientation = fits(piece, coordinate); 
			if (NO_FIT != orientation) {
				PlacedPiece found = new PlacedPiece(piece, coordinate, orientation);
				foundPlaces.add(found);
			}
		}
		return foundPlaces;		
	}

	private int fits(Piece piece, Coordinate coordinate) {
		int baseX = coordinate.getX();
		int baseY = coordinate.getY();
		for (Integer orientation : piece.getOrientations()) {
			char[][] elements = piece.getElements(orientation);
			System.out.println("Trying to fit: ");
			Piece.print(elements);
			if (fits(elements, baseX, baseY)) {	
				return orientation;
			}			
		}
		return NO_FIT;
	}
	
	private boolean fits(char[][] elements, int baseX, int baseY) {
		if (!fitsWithinGrid(elements, baseX, baseY)) {
			return false;
		}
		for (int height = 0; height < elements[0].length; height++) {
			for (int width = 0; width < elements.length; width++) {
				if (Piece.isUsed(elements, width, height) 
						&& isFilled(baseX + height, baseY + width)) {
					return false;
				}				
			}
		}		
		return true;
	}

	private boolean fitsWithinGrid(char[][] elements, int baseX, int baseY) {
		if ((baseX + elements[0].length < GRID_WIDTH)
				&& (baseY + elements.length < GRID_HEIGHT)) {
			return true;
		}
		return false;
	}

	public Coordinate findEmptyPlace() {
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (valueAt(i, j) == EMPTY) {
					return new Coordinate(i, j);
				}
			}
		}		
		return null;
	}
	
	public boolean hasEmptyPlace() {		
		return findEmptyPlace() != null;
	}

	public List<Coordinate> getAllEmptyPlaces() {
		List<Coordinate> foundPlaces = new ArrayList<Coordinate>();
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (valueAt(i, j) == EMPTY) {
					foundPlaces.add(new Coordinate(i, j));
				}
			}
		}		
		return foundPlaces;
	}

	public Piece findFittingPiece(Map<Character, Piece> pieces) {
		for (Piece piece : pieces.values()) {
			if (findPlaceFor(piece)) {
				return piece;
			}
		}
		return null;
	}

	public List<PlacedPiece> findFittingPieces(Map<Character, Piece> pieces) {
		List<PlacedPiece> foundPieces = new ArrayList<PlacedPiece>();
		for (Piece piece : pieces.values()) {
			foundPieces.addAll(findPlacesFor(piece));
		}
		return foundPieces;
	}

	
	
}
