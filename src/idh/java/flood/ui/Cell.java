package idh.java.flood.ui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Cell extends JButton {
	
	private static final Color[] COLORS = {
			new Color(Integer.parseInt("F9CB24", 16)),
			new Color(Integer.parseInt("F96900", 16)),
			new Color(Integer.parseInt("16B11B", 16)),
			new Color(Integer.parseInt("4472CA", 16)),
			new Color(Integer.parseInt("F61067", 16)),
			new Color(Integer.parseInt("00E0D5", 16))
	};
	
	private int colorValue;
	
	public Cell(int colorValue) {
		super();
		setBorder(BorderFactory.createEmptyBorder());
		setBorderPainted(false);
		setRolloverEnabled(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setColorValue(colorValue);
	}
	
	public int getColorValue() {
		return this.colorValue;
	}
	
	public void setColorValue(int colorValue) {
		this.colorValue = colorValue;
		setBackground(COLORS[colorValue]);
	}

}
