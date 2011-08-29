package org.geenz.puzzler;

public class PlacedPiece {

	private Piece piece = null;
	private Coordinate coordinate = null;
	private int orientation = Piece.DEFAULT_ORIENTATION;
	
	public PlacedPiece(Piece piece, Coordinate coordinate, int orientation) {
		this.piece = piece;
		this.coordinate = coordinate;
		this.orientation = orientation;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public int getOrientation() {
		return orientation;
	}			
}
