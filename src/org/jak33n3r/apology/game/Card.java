package org.jak33n3r.apology.game;

public class Card {
	int value;
	CardType card_type;
	
	public Card(int val, CardType type){
		this.value = val;
		this.card_type = type;
	}
	
	public Card(){
		this.value = 0;
		this.card_type = CardType.NONE;
	}
	
	public int getValue(){
		return value;
	}
	
	public CardType getCardType(){
		return card_type;
	}
	
	public void setValue(int val){
		this.value = val;
	}
	
	public void setCardType(CardType type){
		this.card_type = type;
	}
	
	public enum CardType{
		START, FORWARD, BACKWARD, SWAP, SPLIT, SORRY, NONE, FORWARD_START,
		FORWARD_START_DRAW_TWICE, FORWARD_BACKWARD, FORWARD_SWAP, FORWARD_SPLIT
	}
}
