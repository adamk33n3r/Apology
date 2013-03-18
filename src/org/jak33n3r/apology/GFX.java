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
	
	public static int tile_size;

	Dimension size;
	
	Board board;
	
	public GFX(int x, int y) {
		size = new Dimension(x, y);
		//System.out.println(size.height / 20);
		tile_size = size.height / 20;
		//System.out.println(tile_size);
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public static void update() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*
		 * Draw board
		 */
		Tile tile = null;
		int x = tile_size, y = tile_size;
		int incx = tile_size, incy = 0;
		for (Iterator<Tile> it = board.getBoard().iterator(); it.hasNext();) {
			tile = it.next();
			g.setColor(tile.getColor());
			g.fillPolygon(getShape(tile.getShape(), x, y));
			g.setColor(Color.BLACK);
			g.drawPolygon(getShape(tile.getShape(), x, y));
			if (tile.isCorner()) {
				if (incx == tile_size) {
					incx = 0;
					incy = tile_size;
				} else if (incy == -tile_size) {
					incy = 0;
					incx = -tile_size;
				} else if (incx == -tile_size) {
					incx = 0;
					incy = -tile_size;
				} else if (incy == tile_size) {
					incy = 0;
					incx = -tile_size;
				}
			}
			x+=incx;
			y+=incy;
		}x=tile_size*4;y=tile_size*3;incx = tile_size; incy = 0;
		for (Iterator<Tile> it = board.getSlides().iterator(); it.hasNext();) {
			tile = it.next();
			g.setColor(tile.getColor());
			g.fillPolygon(getShape(tile.getShape(), x, y));
			g.setColor(Color.BLACK);
			g.drawPolygon(getShape(tile.getShape(), x, y));
			if (tile.isCorner()) {
				if (incx == tile_size) {
					incx = 0;
					incy = tile_size;
				} else if (incy == -tile_size) {
					incy = 0;
					incx = -tile_size;
				} else if (incx == -tile_size) {
					incx = 0;
					incy = -tile_size;
				} else if (incy == tile_size) {
					incy = 0;
					incx = -tile_size;
				}
			}
			x+=incx;
			y+=incy;
		}
	}
	
	private Polygon getShape(Polygon shape, int x, int y) {
		shape.translate(x,y);
		return shape;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return size;
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Apology GFX Test");
		GFX grafix = new GFX(1000, 1000);
		//GFX grafix = new GFX(500, 500);
		Tile[] board = new Tile[60];
		boolean corner = false;
		for(int i = 0; i < 60; ++i) {
			if (i == 15 || i == 30 || i == 45 || i == 60)
				corner = true;
			board[i] = new Tile(Tile.Properties.REGULAR, Colors.NONE, corner);
			corner = false;
		}
		Tile[] tiles = {
				new Tile(Tile.Properties.SLIDE_START, Colors.GREEN, false),
				new Tile(Tile.Properties.SLIDE_MID, Colors.GREEN, false),
				new Tile(Tile.Properties.SLIDE_END, Colors.GREEN, false),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, true),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, false),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, true),
				new Tile(Tile.Properties.SLIDE_START, Colors.YELLOW, false),
				new Tile(Tile.Properties.SLIDE_MID, Colors.YELLOW, false),
				new Tile(Tile.Properties.SLIDE_END, Colors.YELLOW, false),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, true),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, false),
				new Tile(Tile.Properties.REGULAR, Colors.NONE, true),
		};
		grafix.setBoard(new Board(new ArrayList<Tile>(Arrays.asList(board)), new ArrayList<Tile>(Arrays.asList(tiles))));
		frame.getContentPane().add(grafix);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
