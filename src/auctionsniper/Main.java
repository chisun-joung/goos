package auctionsniper;

import javax.swing.SwingUtilities;

import org.jivesoftware.smack.Chat;
import auctionsniper.ui.MainWindow;

public class Main {

	public static final String AUCTION_RESOURCE = "Auction";
	public static final String ITEM_ID_AS_LOGIN = "auction-%s";
	public static final String AUCTION_ID_FORMAT = ITEM_ID_AS_LOGIN + "@%s/"
			+ AUCTION_RESOURCE;

	public static final String MAIN_WINDOW_NAME = "Auction Sniper Main";
	public static final String SNIPER_STATUS_NAME = "sniper status";
	public static final String JOIN_COMMAND_FORMAT = "Join";
	public static final String BID_COMMAND_FORMAT = "Bid";
	private MainWindow ui;
	@SuppressWarnings("unused")
	private Chat notToBeGCd;

	public Main() throws Exception {
		 startUserInterface();
	}

	public static void main(String... args) throws Exception {

		Main main = new Main();

	}

	private void startUserInterface() throws Exception {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				ui = new MainWindow();
			}
		});
	}
}
