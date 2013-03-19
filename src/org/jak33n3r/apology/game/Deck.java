package org.jak33n3r.apology.game;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
	Card[] deck_of_cards;
	Card cur_card;
	
	public Deck(){
		deck_of_cards = new Card[46];
		cur_card = new Card();
		initDeck();
		cur_card = deck_of_cards[0];
	}
	
	public Card[] getDeckOfCards(){
		return deck_of_cards;
	}
	
	public void initDeck(){
		//0,1,2,3  sorry
		for(int i = 0; i <= 3; ++i){
			deck_of_cards[i].setValue(0);
			deck_of_cards[i].setCardType(Card.CardType.SORRY);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//4,5,6,7,8   1
		for(int i = 4; i <= 8; ++i){
			deck_of_cards[i].setValue(1);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.START);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//9,10,11,12	2
		for(int i = 9; i <= 12; ++i){
			deck_of_cards[i].setValue(2);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.START);
			deck_of_cards[2].setCardType3(Card.CardType.DRAW_TWICE);
		}
		
		//13,14,15,16	3
		for(int i = 13; i <= 16; ++i){
			deck_of_cards[i].setValue(3);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//17,18,19,20	4
		for(int i = 17; i <= 20; ++i){
			deck_of_cards[i].setValue(4);
			deck_of_cards[i].setCardType(Card.CardType.BACKWARD);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//21,22,23,24	5
		for(int i = 21; i <= 24; ++i){
			deck_of_cards[i].setValue(5);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//25,26,27,28	7
		for(int i = 25; i <= 28; ++i){
			deck_of_cards[i].setValue(7);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.SPLIT);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//29,30,31,32	8
		for(int i = 29; i <= 32; ++i){
			deck_of_cards[i].setValue(8);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//33,34,35,36	10
		for(int i = 33; i <= 36; ++i){
			deck_of_cards[i].setValue(10);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.BACKWARD);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//37,38,39,40	11
		for(int i = 37; i <= 40; ++i){
			deck_of_cards[i].setValue(11);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.SWAP);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//41,42,43,44	12
		for(int i = 41; i <= 44; ++i){
			deck_of_cards[i].setValue(12);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
			deck_of_cards[i].setCardType2(Card.CardType.NONE);
			deck_of_cards[i].setCardType3(Card.CardType.NONE);
		}
		
		//NULL terminating index
		deck_of_cards[45].setValue(0);
		deck_of_cards[45].setCardType(Card.CardType.NONE);
		deck_of_cards[45].setCardType2(Card.CardType.NONE);
		deck_of_cards[45].setCardType3(Card.CardType.NONE);
		
	}
	
	public void shuffle(){
		initDeck();
		Collections.shuffle(Arrays.asList(deck_of_cards));
	}
	
	public void NextCard(){
		for(int i = 1; i <= 45; ++i){
			deck_of_cards[i-1] = deck_of_cards[i];
		}
		if(cur_card == null) shuffle();
	}
}
