package org.jak33n3r.apology;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.jak33n3r.apology.game.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("serial")
public class GFX extends JComponent {
	
	public static float tile_size;
	
	Dimension size;
	
	Board board;
	
	private final boolean debug = true;
	
	public GFX(int x, int y) {
		size = new Dimension(x, y);
		//System.out.println(size.height / 20);
		tile_size = size.height / 10;
		//System.out.println(tile_size);
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public static void update() {
		
	}
	
	@Override
	public void paintComponent(Graphics gfx) {
		super.paintComponent(gfx);
		
		Graphics2D g = (Graphics2D) gfx.create();
		g.scale(.5, .5);
		Font font_small = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 100);
		g.setFont(font_small);
		if (debug)
			g.drawString("Tile size: " + tile_size, 50, 50);
		
		/*
		 * Draw logo
		 */
		TextLayout layout = new TextLayout("Apology!", font, g.getFontRenderContext());
		AffineTransform transform = new AffineTransform();
		Shape outline = layout.getOutline(null);
		transform.translate(this.getWidth() - (outline.getBounds().width / 2), this.getHeight() - (outline.getBounds().height / 2));
		Path2D outlinePath = new Path2D.Float(outline);
		outlinePath.transform(transform);
		g.setColor(Color.WHITE);
		g.fill(outlinePath);
		g.setColor(Color.BLACK);
		g.draw(outlinePath);
		
		/*
		 * Draw tiles
		 */
		Tile tile = null;
		float x = (this.getWidth() - (tile_size * 8)), y = (this.getHeight() - (tile_size * 8));
		float incx = tile_size, incy = 0;
		for (Iterator<Tile> it = board.getBoard().iterator(); it.hasNext();) {
			tile = it.next();
			g.setColor(tile.getColor());
			g.fill(getShape(tile.getShape(), (int) x, (int) y));
			g.setColor(Color.BLACK);
			g.draw(getShape(tile.getShape(), (int) x, (int) y));
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
			x += incx;
			y += incy;
		}
		x = this.getWidth() - (tile_size * 8);
		y = this.getHeight() - (tile_size * 8);
		incx = tile_size;
		incy = 0;
		for (Iterator<Tile> it = board.getSlides().iterator(); it.hasNext();) {
			tile = it.next();
			if (tile != null) {
				g.setColor(tile.getColor());
				g.fill(getShape(tile.getShape(), (int) x, (int) y));
				g.setColor(Color.BLACK);
				g.draw(getShape(tile.getShape(), (int) x, (int) y));
				if (debug) {
					g.drawString(String.format("x: %s", x, y), x, y);
					g.drawString(String.format("y: %s", y), x, y + 50);
				}
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
			}
			x += incx;
			y += incy;
		}
	}
	
	private Path2D.Float getShape(Path2D.Float shape, int x, int y) {
		AffineTransform trans = new AffineTransform();
		trans.translate(x, y);
		shape.transform(trans);
		return shape;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return size;
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Apology GFX Test");
		//GFX grafix = new GFX(1000, 1000);
		GFX grafix = new GFX(500, 500);
		Tile[] board = new Tile[60];
		boolean corner = false;
		for (int i = 0; i < 60; ++i) {
			if (i == 15 || i == 30 || i == 45 || i == 60)
				corner = true;
			board[i] = new Tile(Tile.Type.REGULAR, Tile.Orientation.NONE, Colors.NONE, corner);
			corner = false;
		}
		Tile[] tiles = { null, new Tile(Tile.Type.SLIDE_START, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.EAST, Colors.YELLOW, false), null, null, null, null,
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.EAST, Colors.YELLOW, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.EAST, Colors.YELLOW, false), null,
				new Tile(Tile.Type.REGULAR, Tile.Orientation.NONE, Colors.NONE, true),
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.SOUTH, Colors.GREEN, false), null, null, null, null,
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.SOUTH, Colors.GREEN, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.SOUTH, Colors.GREEN, false), null,
				new Tile(Tile.Type.REGULAR, Tile.Orientation.NONE, Colors.NONE, true),
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.WEST, Colors.RED, false), null, null, null, null,
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.WEST, Colors.RED, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.WEST, Colors.RED, false), null,
				new Tile(Tile.Type.REGULAR, Tile.Orientation.NONE, Colors.NONE, true),
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.NORTH, Colors.BLUE, false), null, null, null, null,
				new Tile(Tile.Type.SLIDE_START, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_MID, Tile.Orientation.NORTH, Colors.BLUE, false),
				new Tile(Tile.Type.SLIDE_END, Tile.Orientation.NORTH, Colors.BLUE, false), null,
				new Tile(Tile.Type.REGULAR, Tile.Orientation.NONE, Colors.NONE, true), };
		grafix.setBoard(new Board(new ArrayList<Tile>(Arrays.asList(board)), new ArrayList<Tile>(Arrays.asList(tiles))));
		frame.getContentPane().add(grafix);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
