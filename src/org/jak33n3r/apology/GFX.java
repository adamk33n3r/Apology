package org.jak33n3r.apology;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.jak33n3r.apology.game.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.Iterator;

@SuppressWarnings("serial")
public class GFX extends JComponent {
	
	public static float tile_size;
	
	Dimension size;
	
	public final static boolean debug = false;
		
	JFrame frame;
	
	Player[] players;
	
	public GFX(int x, int y) {
		this.size = new Dimension(x, y);
		tile_size = Math.round(size.height / 10);
	}
	
	public void addPlayers(Player...players) {
		this.players = players;
	}
	
	public void renderPieces(Graphics2D g) {
		for (Player player : this.players)
			player.render(g);
	}
	
	@Override
	public void paintComponent(Graphics gfx) {
		if (!this.isVisible())
			return;
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
		for (Iterator<Tile> it = Apology.getGame().getBoard().getTiles().iterator(); it.hasNext();) {
			tile = it.next();
			tile.setLocation(new Point((int) x, (int) y));
			g.setColor(tile.getColor());
			g.fill(getShape(tile.getShape(), x, y));
			g.setColor(Color.BLACK);
			g.draw(getShape(tile.getShape(), x, y));
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
		for (Iterator<Tile> it = Apology.getGame().getBoard().getSlides().iterator(); it.hasNext();) {
			tile = it.next();
			if (tile != null) {
				g.setColor(tile.getColor());
				g.fill(getShape(tile.getShape(), x, y));
				g.setColor(Color.BLACK);
				g.draw(getShape(tile.getShape(), x, y));
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
		
		/*
		 * Render players
		 */
		this.renderPieces(g);
	}
	
	private Path2D.Float getShape(Path2D.Float shape, float x, float y) {
		AffineTransform trans = new AffineTransform();
		trans.translate(x, y);
		shape.transform(trans);
		return shape;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return size;
	}
	
}
