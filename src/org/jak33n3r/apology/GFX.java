package org.jak33n3r.apology;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.jak33n3r.apology.game.*;
import org.jak33n3r.apology.game.Tile.Properties;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("serial")
public class GFX extends JComponent {
	
	Dimension size;
	int tile_size;
	
	Board board;
	
	public GFX(int x, int y, Board board) {
		this.board = board;
		size = new Dimension(x, y);
		tile_size = size.height / 20;
	}
	
	public static void update() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		//g.fillRect(100, 100, 600, 600);
		for (int i = 0; i < 16; i++) {
			g.setColor(Color.WHITE);
			g.fillRect(10, 50 * (i + 1), tile_size, tile_size);
			g.setColor(Color.BLACK);
			g.drawRect(10, 50 * (i + 1), tile_size, tile_size);
		}
		
		/*
		 * Draw board
		 */
		Tile tile = null;
		int x = 150, y = size.height - tile_size;
		int incx = tile_size, incy = 0;
		for (Iterator<Tile> it = board.getBoard().iterator(); it.hasNext();) {
			tile = it.next();
			g.setColor(Color.BLUE);
			g.fillPolygon(getShape(tile.getShape(), x, y));
			if (tile.isCorner()) {
				if (incx == tile_size) {
					incx = 0;
					incy = -tile_size;
				} else if (incy == -tile_size) {
					incy = 0;
					incx = -tile_size;
				} else if (incx == -tile_size) {
					incx = 0;
					incy = tile_size;
				} else if (incy == tile_size) {
					incy = 0;
					incx = tile_size;
				}
			}
			x+=incx;
			y+=incy;
		}
	}
	
	private Polygon getShape(Polygon shape, int x, int y) {
		shape.translate(x/2,y/2);
		return shape;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return size;
	}
	
	public static void main(String[] args) {
		
		Tile[] tiles = {
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, false),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, true),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, false),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, true),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, false),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, true),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, false),
				new Tile(Tile.Properties.REGULAR, org.jak33n3r.apology.game.Color.NONE, true),
		};
		JFrame frame = new JFrame("Apology GFX Test");
		frame.getContentPane().add(new GFX(1000, 1000, new Board(new ArrayList<Tile>(Arrays.asList(tiles)))));
		frame.pack();
		frame.setVisible(true);
	}
	
}
