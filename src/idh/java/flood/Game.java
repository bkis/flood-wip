package idh.java.flood;

/*
 * Diese Klasse repräsentiert die Spiellogik und auch den Spielzustand
 * (das könnte man später noch auf getrennte Klassen aufteilen...)
 * 
 * ACHTUNG: Die Klasse ist längst nicht fertig!
 */
public class Game {
	
	private static final int[][] NEIGHBORS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static final int[] BOARD_SIZES = {8, 12, 16, 20, 24, 28};
	public static final int DEFAULT_BOARD_SIZE = 16;
	public static final int[] COLOR_COUNTS = {3, 4, 5, 6};
	public static final int DEFAULT_COLOR_COUNT = 4;
	
	private String seed;
	private int[][] board;
	private int colors;
	private int maxTurns;
	private int turns;
	private boolean won;
	private boolean lost;
	
	
	public Game(String seed) {
		this.seed = seed;
		// TODO: Neues Spiel erzeugen...
	}
	
	
	private int calculateMaxTurns(int size, int colors) {
		// TODO
		return 10;
	}

}
