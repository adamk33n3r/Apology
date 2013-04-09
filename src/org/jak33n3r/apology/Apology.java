package org.jak33n3r.apology;

import org.jak33n3r.apology.game.Deck;

/**
 * A Sorry-Like Board Game Called Apology!
 * @author adamk33n3r, jafelker
 *
 */
public class Apology {

	/**
	 * @param args - Command-line arguments
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Apology!");
		Deck deck = new Deck();
		for(int i = 0; i < 45; ++i){
			System.out.println(deck.getDeckOfCards()[i].getValue());
			System.out.println(deck.getDeckOfCards()[i].getCardType());
			deck.shuffle();
			System.out.println(deck.getDeckOfCards()[i].getValue());
			System.out.println(deck.getDeckOfCards()[i].getCardType());
		}
	}

}
