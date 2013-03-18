package org.jak33n3r.apology.game;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> outer_tiles;
	ArrayList<Tile> slide_tiles;

	public Board(ArrayList<Tile> board, ArrayList<Tile> tiles) {
		outer_tiles = board;
		slide_tiles = tiles;
	}
	public ArrayList<Tile> getBoard(){
		return outer_tiles;
	}
	
	public ArrayList<Tile> getSlides() {
		return slide_tiles;
	}
}
