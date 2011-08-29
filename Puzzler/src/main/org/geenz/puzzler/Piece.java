package org.geenz.puzzler;

import java.util.HashMap;
import java.util.Map;

public class Piece {

	public static final int DEFAULT_ORIENTATION = 0;
	public static final int TURNED_90_DEGREES = 90;
	public static final int TURNED_180_DEGREES = 180;
	public static final int TURNED_270_DEGREES = 270;
	
	private char[][] piece = null;
	private Map<Integer, char[][]> orientations = new HashMap<Integer, char[][]>(); 
	
	public Piece(char[][] elements) {
		piece = elements;
		orientations.put(DEFAULT_ORIENTATION, piece);
		orientations.put(TURNED_90_DEGREES, turn(piece));
		orientations.put(TURNED_180_DEGREES, turn(orientations.get(TURNED_90_DEGREES)));
		orientations.put(TURNED_270_DEGREES, turn(orientations.get(TURNED_180_DEGREES)));
	}
	
	public char[][] getElements() {
		return piece;
	}
	
	public char[][] getElements(int orientation) {
		return orientations.get(orientation);
	}
	
	public char getElementAt(int height, int width) {
		return getElementAt(height, width, DEFAULT_ORIENTATION);
	}

	public char getElementAt(int height, int width, int orientation) {		
		return orientations.get(orientation)[height][width];
	}

	public int getWidth() {
		return getWidth(DEFAULT_ORIENTATION);
	}
	
	public int getWidth(int orientation) {
		return orientations.get(orientation)[0].length;
	}

	public int getHeight() {
		return getHeight(DEFAULT_ORIENTATION);
	}
	
	public int getHeight(int orientation) {
		return orientations.get(orientation).length;
	}

	protected static char[] getColumnOfArray(char[][] elements, int columnNumber) {
		char[] column = new char[elements.length];
		for (int i = 0; i < elements.length; i++) {
			column[i] = elements[i][columnNumber];
		}
		return column;		
	}

	protected static char[][] turn(char[][] input) {
		char[][] turned = new char[input[0].length][input.length];
		int row = 0;
		for (int i = input[0].length - 1; i >= 0; i--) {
			turned[row++] = getColumnOfArray(input, i);
		}
		return turned;	
	}
	
}
