package org.jak33n3r.apology.game;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;

import org.jak33n3r.apology.GFX;

public class Tile {
	
	Piece occupant;
	Color color;
	Path2D.Float shape;
	
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
		this.shape = new Path2D.Float(shape);
		System.out.println("Creating shape: " + orient + " with Orientation: " + orient + " with id: " + orient.id);
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
	
	/*public Polygon getShape() {
		//return shape;
		return new Polygon(shape.xpoints, shape.ypoints, shape.npoints);
	}*/
	
	public Path2D.Float getShape() {
		return new Path2D.Float(this.shape);
	}
	
	private void setShape(Polygon shape, Type property) {
		switch (property) {
			case SLIDE_START:
				shape.addPoint(0, GFX.tile_size / 4);
				shape.addPoint(0, GFX.tile_size / 4 * 3);
				shape.addPoint(GFX.tile_size / 2, GFX.tile_size / 4 * 3);
				shape.addPoint(GFX.tile_size / 20 * 19, GFX.tile_size);
				shape.addPoint(GFX.tile_size / 20 * 19, 0);
				shape.addPoint(GFX.tile_size / 2, GFX.tile_size / 4);
				break;
			case SLIDE_MID:
				shape.addPoint(0, GFX.tile_size / 4);
				shape.addPoint(GFX.tile_size, GFX.tile_size / 4);
				shape.addPoint(GFX.tile_size, GFX.tile_size / 4 * 3);
				shape.addPoint(0, GFX.tile_size / 4 * 3);
				break;
			case SLIDE_END:
				shape.addPoint(GFX.tile_size / 4, GFX.tile_size / 4);
				shape.addPoint(GFX.tile_size / 4, GFX.tile_size / 4 * 3);
				shape.addPoint(GFX.tile_size, GFX.tile_size / 4 * 3);
				shape.addPoint(GFX.tile_size, GFX.tile_size / 4);
				break;
			case START:
				break;
			case REGULAR:
				shape.addPoint(0, 0);
				shape.addPoint(0, GFX.tile_size);
				shape.addPoint(GFX.tile_size, GFX.tile_size);
				shape.addPoint(GFX.tile_size, 0);
				break;
			case HOME_SHUTE:
				shape.addPoint(0, 0);
				shape.addPoint(0, 10);
				shape.addPoint(10, 10);
				shape.addPoint(10, 0);
				break;
			case HOME:
				break;
			case START_TILE:
				shape.addPoint(3, 3);
				shape.addPoint(3, 7);
				shape.addPoint(10, 7);
				shape.addPoint(10, 3);
				break;
		}
	}
	
	public boolean isCorner() {
		return is_corner;
	}
	
}
