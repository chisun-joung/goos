package auctionsniper.ui;

import static auctionsniper.Main.MAIN_WINDOW_NAME;
import static auctionsniper.Main.SNIPER_STATUS_NAME;
import static endtoendtest.ApplicationRunner.STATUS_JOINING;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private final JLabel sniperStatus = createLabel(STATUS_JOINING);
	public MainWindow() {
		super("Auction Sniper");
		setName(MAIN_WINDOW_NAME);
		add(sniperStatus);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private static JLabel createLabel(String initialText) { 
		JLabel result = new JLabel(initialText); 
		result.setName(SNIPER_STATUS_NAME); 
		result.setBorder(new LineBorder(Color.BLACK)); 
		return result;
	}
}
