package org.jak33n3r.apology;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;

public class GFX extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Apology GFX Test");
		frame.getContentPane().add(new GFX());
		frame.pack();
		frame.setVisible(true);
	}
	
}
