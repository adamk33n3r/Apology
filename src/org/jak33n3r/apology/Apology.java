package org.jak33n3r.apology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

import org.jak33n3r.apology.game.Board;
import org.jak33n3r.apology.game.Colors;
import org.jak33n3r.apology.game.Deck;
import org.jak33n3r.apology.game.Player;
import org.jak33n3r.apology.game.Tile;

/**
 * A Sorry-Like Board Game Called Apology!
 * @author adamk33n3r, jafelker
 * 
 */
public class Apology {
	
	private static Apology apology;
	private static Random rand;
	private GFX grafix;
	private Board board;
	
	/**
	 * @param args - Command-line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Apology!");
		/*Deck deck = new Deck();
		for (int i = 0; i < 45; ++i) {
			System.out.println(deck.getDeckOfCards()[i].getValue());
			System.out.println(deck.getDeckOfCards()[i].getCardType());
			deck.shuffle();
			System.out.println(deck.getDeckOfCards()[i].getValue());
			System.out.println(deck.getDeckOfCards()[i].getCardType());
		}*/
		
		apology = new Apology();
		apology.init();
		apology.start();
	}
	
	public static int randInt(int upper) {
		return rand.nextInt(upper);
	}
	
	public static Apology getGame() {
		return apology;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public void start() {
		this.grafix.addPlayers(new Player(Colors.GREEN), new Player(Colors.RED), new Player(Colors.BLUE), new Player(Colors.YELLOW));
		this.grafix.frame = new JFrame("Apology GFX Test");
		this.grafix.frame.getContentPane().add(this.grafix);
		this.grafix.frame.pack();
		this.grafix.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.grafix.frame.setVisible(true);
		/*while (this.grafix.isVisible()) {
		}*/
	}
	
	public void init() {
		
		rand = new Random();
		
		this.grafix = new GFX(800, 800);
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
		this.board = new Board(new ArrayList<Tile>(Arrays.asList(board)), new ArrayList<Tile>(Arrays.asList(tiles)));
		//System.out.println(this.board);
	}
	
}
