package org.geenz.puzzler;

public class Coordinate {

	int x = 0;
	int y = 0;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coordinate other = (Coordinate) obj;
		return (other.getX() == getX() && other.getY() == getY());
	}
}
