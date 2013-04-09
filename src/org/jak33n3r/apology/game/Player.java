package org.jak33n3r.apology.game;

import java.awt.Graphics2D;

import org.jak33n3r.apology.Apology;
import org.jak33n3r.apology.Renderable;

public class Player implements Renderable {
	Piece[] pieces = new Piece[4];
	Colors color;
	
	public Player(Colors color) {
		this.color = color;
		for (int i = 0; i < 4; i++)
			this.pieces[i] = new Piece(i, color, Apology.getGame().getBoard().getTiles().get(this.color.ordinal()));
	}

	@Override
	public void render(Graphics2D g) {
		for (Piece piece : this.pieces)
			piece.render(g);
	}
	
}
