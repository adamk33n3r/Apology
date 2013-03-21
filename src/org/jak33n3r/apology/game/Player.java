package org.jak33n3r.apology.game;

public class Player {
	Piece[] pieces = new Piece[4];
	Colors color;
	
	public Player(Colors color) {
		this.color = color;
		for (int i = 0; i < pieces.length; i++)
			this.pieces[i] = new Piece(i, color);
	}
	
}
