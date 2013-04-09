package org.jak33n3r.apology.game;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D.Float;

import org.jak33n3r.apology.GFX;

public class Tile {
	
	Piece occupant;
	Color color;
	Float shape;
	
	boolean is_corner;
	
	public enum Type {
		SLIDE_START, SLIDE_MID, SLIDE_END, START, REGULAR, HOME_SHUTE, HOME, START_TILE
	}
	
	public enum Orientation {
		NORTH(1), SOUTH(3), EAST(2), WEST(0), NONE(0);
		public final int id;
		
		Orientation(int id) {
			this.id = id;
		}
		
	}
	
	public Tile(Type type, Orientation orient, Colors color, boolean is_corner) {
		Polygon shape = new Polygon();
		setShape(shape, type);
		this.shape = new Float(shape);
		System.out.println("Creating tile: " + type + " with Orientation: " + orient + " with id: " + orient.id);
		if (orient.id != 0) {
			AffineTransform trans = new AffineTransform();
			trans.rotate(Math.PI / 2.0 * orient.id, GFX.tile_size / 2, GFX.tile_size / 2);
			this.shape.transform(trans);
		}
		setColor(color);
		this.is_corner = is_corner;
	}
	
	public java.awt.Color getColor() {
		return color;
	}
	
	private void setColor(Colors color) {
		switch (color) {
			case BLUE:
				this.color = java.awt.Color.BLUE;
				break;
			case YELLOW:
				this.color = java.awt.Color.YELLOW;
				break;
			case GREEN:
				this.color = java.awt.Color.GREEN;
				break;
			case RED:
				this.color = java.awt.Color.RED;
				break;
			case NONE:
				this.color = java.awt.Color.WHITE;
				break;
		}
	}
	
	public Float getShape() {
		return new Float(this.shape);
	}
	
	private void addPoint(Polygon shape, float x, float y) {
		shape.addPoint((int) x, (int) y);
	}
	
	private void setShape(Polygon shape, Type property) {
		switch (property) {
			case SLIDE_START:
				addPoint(shape,0, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size / 2, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size / 20 * 15, GFX.tile_size / 20 * 17);
				addPoint(shape,GFX.tile_size / 20 * 15, GFX.tile_size / 20 * 2);
				addPoint(shape,GFX.tile_size / 2, GFX.tile_size / 10 * 3);
				addPoint(shape,0, GFX.tile_size / 10 * 3);
				break;
			case SLIDE_MID:
				addPoint(shape,0, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size, GFX.tile_size / 10 * 3);
				addPoint(shape,0, GFX.tile_size / 10 * 3);
				break;
			case SLIDE_END:
				addPoint(shape,GFX.tile_size / 10 * 3, GFX.tile_size / 10 * 3);
				addPoint(shape,GFX.tile_size / 10 * 3, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size, GFX.tile_size / 10 * 7);
				addPoint(shape,GFX.tile_size, GFX.tile_size / 10 * 3);
				break;
			case START:
				break;
			case REGULAR:
				addPoint(shape,0, 0);
				addPoint(shape,0, GFX.tile_size);
				addPoint(shape,GFX.tile_size, GFX.tile_size);
				addPoint(shape,GFX.tile_size, 0);
				break;
			case HOME_SHUTE:
				addPoint(shape, 0, 0);
				addPoint(shape, 0, 10);
				addPoint(shape, 10, 10);
				addPoint(shape, 10, 0);
				break;
			case HOME:
				break;
			case START_TILE:
				addPoint(shape, 3, 3);
				addPoint(shape, 3, 7);
				addPoint(shape, 10, 7);
				addPoint(shape, 10, 3);
				break;
		}
	}
	
	public boolean isCorner() {
		return is_corner;
	}
	
}
