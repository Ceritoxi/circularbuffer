package com.szeretematejet.esakakaotis.circularbuffer;

public class NotAllowedToRead extends RuntimeException {

	private static final long serialVersionUID = -2818101140861530303L;

	public NotAllowedToRead() {

	}

	public NotAllowedToRead(String message) {
		super(message);
	}
}
