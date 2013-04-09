package auctionsniper;

public class AuctionSniper implements AuctionEventListener{

	private SniperListener listener;
	private Auction auction;

	public AuctionSniper(SniperListener sniperListener) {
		this.listener = sniperListener;
	}

	public AuctionSniper(Auction auction, SniperListener sniperListener) {
		this.auction = auction;
		this.listener = sniperListener;
	}

	public void auctionClosed() {
		listener.sniperLost();
	}

	@Override
	public void currentPrice(int price, int increment) {
		auction.bid(price + increment);
		listener.sniperBidding();		
	}

}
