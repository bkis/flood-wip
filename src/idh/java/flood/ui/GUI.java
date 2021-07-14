package idh.java.flood.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import idh.java.flood.Game;


public class GUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private UICallbacks uiCallbacks;
	private JPanel gamePanel;

	public GUI(UICallbacks uiCallbacks) {
		this.uiCallbacks = uiCallbacks;
		setupLookAndFeel();
		setTitle("Flood"); // Fenstertitel
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Schließen-Aktion
		setPreferredSize(new Dimension(400, 400)); // bevorz. Fenstergröße
		setResizable(false); // Fenstergröße nicht manuell änderbar
		initMenu(); // Fenster-Menü initialisieren (siehe Methode unten!)
		pack(); // Fenstergröße anpassen
		setLocationRelativeTo(null); // Fensterposition
		setVisible(true); // Fenster anzeigen
	}
	
	private void setupLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Could not set system L&F :(");
		}
	}
	
	private void initMenu() {
		// Game - New - Default
		JMenuItem miNewDefault = new JMenuItem("Default");
		miNewDefault.setActionCommand("new game default");
		miNewDefault.addActionListener(this);
		
		// Game - New - Retry
		JMenuItem miNewRetry = new JMenuItem("Retry");
		miNewRetry.setEnabled(false);
		miNewRetry.setActionCommand("new game retry");
		miNewRetry.addActionListener(this);
		
		// Game - New - Custom
		JMenuItem miNewCustom = new JMenuItem("Custom");
		miNewCustom.setActionCommand("new game custom");
		miNewCustom.addActionListener(this);
		
		// Game - New - From Seed
		JMenuItem miNewFromSeed = new JMenuItem("From Seed");
		miNewFromSeed.setActionCommand("new game from seed");
		miNewFromSeed.addActionListener(this);
		
		// Game - New
		JMenu miNew = new JMenu("New");
		miNew.add(miNewDefault);
		miNew.add(miNewRetry);
		miNew.add(miNewCustom);
		miNew.add(miNewFromSeed);
		
		// Game - Exit
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.setActionCommand("exit");
		miExit.addActionListener(this);
		
		// Game
		JMenu mGame = new JMenu("Game");
		mGame.add(miNew);
		mGame.add(miExit);

		// Info - Instructions
		JMenuItem miInstr = new JMenuItem("Instructions");
		miInstr.setActionCommand("instructions");
		miInstr.addActionListener(this);
		
		// Info - About
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.setActionCommand("about");
		miAbout.addActionListener(this);
		
		// Info
		JMenu mInfo = new JMenu("Info");
		mInfo.add(miInstr);
		mInfo.add(miAbout);
		
		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(mGame);
		menuBar.add(mInfo);
		setJMenuBar(menuBar);
	}
	
	private void initGameBoard(Game game) {
		System.out.println("SIZE: " + game.getSize());
		System.out.println("COLORS: " + game.getColors());
		
		gamePanel = new JPanel();
		GridLayout layout = new GridLayout(game.getSize(), game.getSize());
		gamePanel.setLayout(layout);
		
		
		for (int y = 0; y < game.getBoard().length; y++) {
			for (int x = 0; x < game.getBoard()[y].length; x++) {
				Cell cell = new Cell(game.getBoard()[y][x]);
				cell.setActionCommand("flood");
				cell.addActionListener(this);
				gamePanel.add(cell);
			}
		}
		
		add(gamePanel);
		pack();
	}
	
	private void flood(Game game) {
		for (int y = 0; y < game.getBoard().length; y++) {
			for (int x = 0; x < game.getBoard()[y].length; x++) {
				((Cell)gamePanel.getComponent((y * game.getSize()) + x))
					.setColorValue(game.getBoard()[y][x]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "new game default":
			initGameBoard(uiCallbacks.newGame("Gib uns ein neues Spiel!!"));
			break;
		case "about":
			//TODO
			System.out.println(e.getActionCommand());
			break;
		case "instructions":
			//TODO
			System.out.println(e.getActionCommand());
			break;
		case "exit":
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			break;
		case "new game from seed":
			//TODO
			System.out.println(e.getActionCommand());
			break;
		case "new game custom":
			//TODO
			System.out.println(e.getActionCommand());
			break;
		case "new game retry":
			//TODO
			System.out.println(e.getActionCommand());
			break;
		case "flood":
			// TODO
			if (e.getSource() instanceof Cell) {
				Cell cell = (Cell) e.getSource();
				flood(uiCallbacks.flood(cell.getColorValue()));
			}
			break;
		default:
			break;
		}
	}

}
