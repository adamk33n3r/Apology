package org.jak33n3r.apology.game;

public class Card {
	int value;
	CardType card_type;
	CardType card_type2;
	CardType card_type3;
	
	public Card(){
		value = 0;
		card_type = CardType.NONE;
		card_type2 = CardType.NONE;
		card_type3 = CardType.NONE;
	}
	
	public int getValue(){
		return value;
	}
	
	public CardType getCardType(){
		return card_type;
	}
	
	public CardType getCardType2(){
		return card_type2;
	}
	
	public CardType getCardType3(){
		return card_type3;
	}
	
	public void setValue(int val){
		this.value = val;
	}
	
	public void setCardType(CardType type){
		this.card_type = type;
	}
	
	public void setCardType2(CardType type){
		this.card_type2 = type;
	}
	
	public void setCardType3(CardType type){
		this.card_type3 = type;
	}
	
	public enum CardType{
		START, FORWARD, BACKWARD, SWAP, SPLIT, SORRY, DRAW_TWICE, NONE
	}
}
