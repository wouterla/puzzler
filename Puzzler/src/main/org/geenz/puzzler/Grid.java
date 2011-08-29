package org.geenz.puzzler;

import java.util.Arrays;


public class Grid {

	private static final char EMPTY = '0';

	private static final int GRID_WIDTH = 11;

	private static final int GRID_HEIGHT = 5;
	
	private char[][] grid = new char[GRID_WIDTH][GRID_HEIGHT];
	
	public Grid() {
		// initialize grid
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], EMPTY);	
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

	public void place(int i, int j, Piece piece, int orientation) {
		for (int k = 0; k < piece.getWidth(orientation); k++) {
			for (int l = 0; l < piece.getHeight(orientation); l++) {
				fillWith(i + k, j + l, piece.getElementAt(l, k, orientation));				
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
	}
}
