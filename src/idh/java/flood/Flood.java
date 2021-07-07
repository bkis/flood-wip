package idh.java.flood;

import idh.java.flood.ui.GUI;
import idh.java.flood.ui.UICallbacks;

public class Flood {
	
	private Game game;

	public static void main(String[] args) {
		new Flood();
	}
	
	public Flood() {
		// ... Programm startet ...
		
		// UI Callbacks werder definiert und ...
		UICallbacks uiCallbacks = new UICallbacks() {
			@Override
			public Game newGame(String seed) {
				game = new Game(seed);
				return game;
			}
			@Override
			public Game flood(int colorValue) {
				return game.flood(colorValue);
			}
		};
		
		// ... an die GUI übergeben!
		new GUI(uiCallbacks); // neue GUI erzeugen
	}

}
