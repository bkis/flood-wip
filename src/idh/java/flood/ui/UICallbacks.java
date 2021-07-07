package idh.java.flood.ui;

import idh.java.flood.Game;

/*
 * Dieses Interface definiert die Kommunikation zwischen der GUI und der
 * Programmlogik!
 */
public interface UICallbacks {
	
	public Game newGame(String seed); // Aktion: Neues Spiel starten!
	public Game flood(int colorValue); // Aktion: Spielbrett mit Farbe fluten
	
	// TODO ... es folgen hier noch weitere ...

}
