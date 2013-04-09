package org.jak33n3r.apology.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	Card[] deck_of_cards;
	int cur_card;
	
	public Deck(){
		deck_of_cards = new Card[46];
		for(int i = 0; i < 45; ++i){
			deck_of_cards[i] = new Card();
		}
		initDeck();
		cur_card = 0;
	}
	
	public Card[] getDeckOfCards(){
		return deck_of_cards;
	}
	
	public void initDeck(){
		//0,1,2,3  sorry
		for(int i = 0; i <= 3; ++i){
			deck_of_cards[i].setValue(0);
			deck_of_cards[i].setCardType(Card.CardType.SORRY);
		}
		
		//4,5,6,7,8   1
		for(int i = 4; i <= 8; ++i){
			deck_of_cards[i].setValue(1);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD_START);
		}
		
		//9,10,11,12	2
		for(int i = 9; i <= 12; ++i){
			deck_of_cards[i].setValue(2);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD_START_DRAW_TWICE);
		}
		
		//13,14,15,16	3
		for(int i = 13; i <= 16; ++i){
			deck_of_cards[i].setValue(3);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
		}
		
		//17,18,19,20	4
		for(int i = 17; i <= 20; ++i){
			deck_of_cards[i].setValue(4);
			deck_of_cards[i].setCardType(Card.CardType.BACKWARD);
		}
		
		//21,22,23,24	5
		for(int i = 21; i <= 24; ++i){
			deck_of_cards[i].setValue(5);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
		}
		
		//25,26,27,28	7
		for(int i = 25; i <= 28; ++i){
			deck_of_cards[i].setValue(7);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD_SPLIT);
		}
		
		//29,30,31,32	8
		for(int i = 29; i <= 32; ++i){
			deck_of_cards[i].setValue(8);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
		}
		
		//33,34,35,36	10
		for(int i = 33; i <= 36; ++i){
			deck_of_cards[i].setValue(10);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD_BACKWARD);
		}
		
		//37,38,39,40	11
		for(int i = 37; i <= 40; ++i){
			deck_of_cards[i].setValue(11);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD_SWAP);
		}
		
		//41,42,43,44	12
		for(int i = 41; i <= 44; ++i){
			deck_of_cards[i].setValue(12);
			deck_of_cards[i].setCardType(Card.CardType.FORWARD);
		}		
	}
	
	public void shuffle(){
		List<Card> lst = Arrays.asList(deck_of_cards);
		Collections.shuffle(lst);
		deck_of_cards = (Card[]) lst.toArray();
		cur_card = 0;
	}
	
	public int drawCard(){
		++cur_card;
		if(cur_card == 44) shuffle();
		return cur_card;
	}
}
