package org.jak33n3r.apology.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Random;

import org.jak33n3r.apology.Apology;
import org.jak33n3r.apology.GFX;
import org.jak33n3r.apology.Renderable;

public class Piece implements Renderable {
	enum State {
		ON_BOARD, IN_SHUTE, IN_START, IN_HOME
	}
	
	int num;
	Colors color;
	State state;
	Tile tile;
	
	/**
	 * Creates a Piece
	 * @param num - The piece number
	 * @param color - Color of the piece
	 * @param tile - The tile that the piece is on
	 */
	public Piece(int num, Colors color, Tile tile) {
		this.num = num;
		this.color = color;
		this.tile = tile;
		this.state = State.IN_START;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(this.color.getColor());
		Polygon p = new Polygon(new int[] { tile.loc.x + (int) (GFX.tile_size / 2), tile.loc.x, tile.loc.x + (int) GFX.tile_size }, new int[] { tile.loc.y,
				tile.loc.y + (int) GFX.tile_size, tile.loc.y + (int) GFX.tile_size }, 3);
		int x = Apology.randInt(50);
		int y = Apology.randInt(50);
		p.translate(x - 25, y - 25);
		g.fill(p);
		g.setColor(Color.BLACK);
		g.draw(p);
	}
	
}
