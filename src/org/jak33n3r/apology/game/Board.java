package org.jak33n3r.apology.game;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> outer_tiles;

	public Board(ArrayList<Tile> tiles) {
		outer_tiles = tiles;
	}
	public ArrayList<Tile> getBoard(){
		return outer_tiles;
	}
}