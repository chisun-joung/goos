package auctionsniper;

import javax.swing.SwingUtilities;

import auctionsniper.ui.MainWindow;


public class SniperStateDisplayer implements SniperListener {

	private MainWindow ui;

	public SniperStateDisplayer(MainWindow ui) {
		this.ui = ui;
	}

	@Override
	public void sniperLost() {
		showStatus(MainWindow.STATUS_LOST);
	}

	@Override
	public void sniperBidding() {
		showStatus(MainWindow.STATUS_BIDDING);
	}
	
	private void showStatus(final String status) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ui.showStatus(status);
			}
		});
		
	}
}
