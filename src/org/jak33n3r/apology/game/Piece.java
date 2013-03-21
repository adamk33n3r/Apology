package org.jak33n3r.apology.game;

public class Piece {
	enum State{
		ON_BOARD, IN_SHUTE, IN_START, IN_HOME
	}
	int num;
	Colors color;
	State state;
	
	public Piece(int num, Colors color) {
		this.num = num;
		this.color = color;
		this.state = State.IN_START;
	}
	
}
