package auctionsniper;

import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

public class AuctionMessageTranslator implements MessageListener {

	private AuctionEventListener listener;

	public AuctionMessageTranslator(AuctionEventListener listener) {
		this.listener = listener;
	}

	public AuctionMessageTranslator(String user, AuctionEventListener listener) {
		this.listener = listener;
	}

	@Override
	public void processMessage(Chat chat, Message message) {
		AuctionEvent event = AuctionEvent.from(message.getBody());

		String evetType = event.type();
		if ("CLOSE".equals(evetType)) {
			listener.auctionClosed();
		} else if ("PRICE".equals(evetType)) {
			listener.currentPrice(event.currentPrice(),event.increment());
		}
	}

	private static class AuctionEvent {
		private final Map<String,String> fields = new HashMap<String,String>();

		public static AuctionEvent from(String messageBody) {
			AuctionEvent event = new AuctionEvent();
			for(String field : fieldsIn(messageBody)) {
				event.addField(field);
			}
			return event;
		}

		private void addField(String field) {
			String[] pair = field.split(":");
			fields.put(pair[0].trim(), pair[1].trim());
		}

		private static String[] fieldsIn(String messageBody) {
			return messageBody.split(";");
		}

		public String type() {
			return get("Event");
		}

		private String get(String fieldName) {
			return fields.get(fieldName);
		}

		public int increment() {
			return getInt("Increment");
		}

		public int currentPrice() {
			return getInt("CurrentPrice");
		}
		
		private int getInt(String fieldName) {
			return Integer.parseInt(get(fieldName));
		}
	}
}
