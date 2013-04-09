package org.jak33n3r.apology.game;

import java.awt.Graphics2D;
import java.awt.Point;

import org.jak33n3r.apology.Renderable;

public class Piece implements Renderable {
	enum State{
		ON_BOARD, IN_SHUTE, IN_START, IN_HOME
	}
	int num;
	Colors color;
	State state;
	Point loc;
	
	public Piece(int num, Colors color) {
		this.num = num;
		this.color = color;
		this.state = State.IN_START;
		this.loc = new Point(0,0);
	}

	@Override
	public void render(Graphics2D g) {
		
	}
	
}
