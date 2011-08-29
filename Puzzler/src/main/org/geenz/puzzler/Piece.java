package org.geenz.puzzler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Piece {

	public static final int DEFAULT_ORIENTATION = 0;
	public static final int TURNED_90_DEGREES = 90;
	public static final int TURNED_180_DEGREES = 180;
	public static final int TURNED_270_DEGREES = 270;
	public static final int DEFAULT_ORIENTATION_FLIPPED = -360;
	public static final int TURNED_90_DEGREES_FLIPPED = -90;
	public static final int TURNED_180_DEGREES_FLIPPED = -180;
	public static final int TURNED_270_DEGREES_FLIPPED = -270;
	
	private char[][] piece = null;
	private Map<Integer, char[][]> orientations = new HashMap<Integer, char[][]>(); 
	
	public Piece(char[][] elements) {
		piece = elements;
		orientations.put(DEFAULT_ORIENTATION, piece);
		orientations.put(TURNED_90_DEGREES, turn(piece));
		orientations.put(TURNED_180_DEGREES, turn(orientations.get(TURNED_90_DEGREES)));
		orientations.put(TURNED_270_DEGREES, turn(orientations.get(TURNED_180_DEGREES)));
		orientations.put(DEFAULT_ORIENTATION_FLIPPED, flip(orientations.get(DEFAULT_ORIENTATION)));
		orientations.put(TURNED_90_DEGREES_FLIPPED, flip(orientations.get(TURNED_90_DEGREES)));
		orientations.put(TURNED_180_DEGREES_FLIPPED, flip(orientations.get(TURNED_180_DEGREES)));
		orientations.put(TURNED_270_DEGREES_FLIPPED, flip(orientations.get(TURNED_270_DEGREES)));
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

	protected static boolean isUsed(char[][] elements, int width, int height) {
		return elements[width][height] != Grid.EMPTY;
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
	
	protected Set<Integer> getOrientations() {
		return orientations.keySet();
	}

	public static char[][] flip(char[][] elements) {
		char[][] flipped = new char[elements.length][elements[0].length];
		for (int i = 0; i < elements.length; i++) {
			flipped[i] = reverseRow(elements[i]);
		}
		return flipped;	
	}
	
	protected static void print(char[][] elements) {
		for (int j = elements.length - 1; j >= 0 ; j--) {
			for (int i = 0; i < elements[0].length; i++) {
				System.out.print(elements[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static char[] reverseRow(char[] elements) {
		char[] result = new char[elements.length];
		int index = 0;
		for (int i = elements.length - 1; i >= 0 ; i--) {
			result[index++] = elements[i]; 
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Piece)) {
			return false;
		}
		return Arrays.equals(piece, ((Piece) obj).getElements());
	}
}
