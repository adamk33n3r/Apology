package org.jak33n3r.apology.game;

import java.awt.Color;

public enum Colors {
	BLUE, YELLOW, GREEN, RED, NONE;
	public Color getColor() {
		switch (this) {
			case BLUE:
				return Color.BLUE;
			case YELLOW:
				return Color.YELLOW;
			case GREEN:
				return Color.GREEN;
			case RED:
				return Color.RED;
			case NONE:
				return Color.WHITE;
			default:
				return Color.WHITE;
		}
	}
}
