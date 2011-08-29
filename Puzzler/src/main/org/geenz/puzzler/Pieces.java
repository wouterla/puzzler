package org.geenz.puzzler;

import java.util.Map;
import java.util.TreeMap;

public class Pieces {
	public final static Piece pieceA = new Piece(new char[][] {
			{ 'A', 'A' }, 
			{ '0', 'A' }, 
			{ '0', 'A' }});
	public final static Piece pieceB = new Piece(new char[][] {
			{ 'B', 'B' }, 
			{ 'B', 'B' }, 
			{ '0', 'B' }});
	public final static Piece pieceC = new Piece(new char[][] {
			{ 'C', 'C' }, 
			{ '0', 'C' }, 
			{ '0', 'C' }, 
			{ '0', 'C' }});
	public final static Piece pieceD = new Piece(new char[][] {
			{ '0', 'D' }, 
			{ 'D', 'D' }, 
			{ '0', 'D' }, 
			{ '0', 'D' }});
	public final static Piece pieceE = new Piece(new char[][] {
			{ 'E', '0' }, 
			{ 'E', 'E' }, 
			{ '0', 'E' }, 
			{ '0', 'E' }});
	public final static Piece pieceF = new Piece(new char[][] {
			{ 'F', 'F' }, 
			{ '0', 'F' }});
	public final static Piece pieceG = new Piece(new char[][] {
			{ 'G', 'G', 'G' }, 
			{ '0', '0', 'G' },
			{ '0', '0', 'G'}});
	public final static Piece pieceH = new Piece(new char[][] {
			{ 'H', 'H', '0' }, 
			{ '0', 'H', 'H' },
			{ '0', '0', 'H'}});
	public final static Piece pieceI = new Piece(new char[][] {
			{ 'I', '0', 'I' },
			{ 'I', 'I', 'I'}});
	public final static Piece pieceJ = new Piece(new char[][] {
			{ 'J' }, 
			{ 'J' }, 
			{ 'J' }, 
			{ 'J' }});
	public final static Piece pieceK = new Piece(new char[][] {
			{ 'K', 'K' }, 
			{ 'K', 'K' }});
	public final static Piece pieceL = new Piece(new char[][] {
			{ '0', 'L', '0' }, 
			{ 'L', 'L', 'L' },
			{ '0', 'L', '0'}});

	public final static Map<Character, Piece> pieces = new TreeMap<Character, Piece>();
	
	static {
		pieces.put('A', pieceA);
		pieces.put('B', pieceB);
		pieces.put('C', pieceC);
		pieces.put('D', pieceD);
		pieces.put('E', pieceE);
		pieces.put('F', pieceF);
		pieces.put('G', pieceG);
		pieces.put('H', pieceH);
		pieces.put('I', pieceI);
		pieces.put('J', pieceJ);
		pieces.put('K', pieceK);
		pieces.put('L', pieceL);
	}
}
