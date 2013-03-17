package org.jak33n3r.apology.game;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;

public class Tile {
	Piece occupant;
	java.awt.Color color;
	Polygon shape;
	boolean is_corner;
	public enum Properties{
		SLIDE_START, SLIDE_MID, SLIDE_END, START, REGULAR, HOME_SHUTE, HOME, START_TILE
	}
	public Tile(Properties property, Color color, boolean is_corner){
		setShape(property);
		setColor(color);
		this.is_corner = is_corner;
	}
	public java.awt.Color getColor(){
		return color;
	}
	private void setColor(Color color){
		switch(color){
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
	public Polygon getShape(){
		return shape;
	}
	private void setShape(Properties property){
		ArrayList<Point> points = new ArrayList<Point>();
		switch(property){
			case SLIDE_START:
				points.add(new Point(0,3));
				points.add(new Point(0,7));
				points.add(new Point(5,7));
				points.add(new Point(9,10));
				points.add(new Point(9,0));
				points.add(new Point(5,3));
				break;
			case SLIDE_MID:
				points.add(new Point(0,3));
				points.add(new Point(10,3));
				points.add(new Point(0,7));
				points.add(new Point(10,7));
				break;
			case SLIDE_END:
				points.add(new Point(3,3));
				points.add(new Point(3,7));
				points.add(new Point(10,7));
				points.add(new Point(10,3));
				break;
			case START:
				break;
			case REGULAR:
				points.add(new Point(0,0));
				points.add(new Point(0,10));
				points.add(new Point(10,10));
				points.add(new Point(10,0));
				break;
			case HOME_SHUTE:
				points.add(new Point(0,0));
				points.add(new Point(0,10));
				points.add(new Point(10,10));
				points.add(new Point(10,0));
				break;
			case HOME:
				break;
			case START_TILE:
				points.add(new Point(3,3));
				points.add(new Point(3,7));
				points.add(new Point(10,7));
				points.add(new Point(10,3));
				break;
		}
		int[] xarr = new int[points.size()];
		int[] yarr = new int[points.size()];
		Point point = null;
		int i = 0;
		//System.out.println(points);
		for(Iterator<Point> it = points.iterator(); it.hasNext();){
			point = it.next();
			//System.out.println(point);
			xarr[i] = point.x;
			yarr[i] = point.y;
			i++;
		}
		shape = new Polygon(xarr,yarr,points.size());
	}
	public boolean isCorner(){
		return is_corner;
	}
}
