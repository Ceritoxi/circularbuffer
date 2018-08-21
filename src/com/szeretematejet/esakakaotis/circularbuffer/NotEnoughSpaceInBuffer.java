package com.szeretematejet.esakakaotis.circularbuffer;

public class NotEnoughSpaceInBuffer extends Exception {

	private static final long serialVersionUID = 4512586039885595151L;

	public NotEnoughSpaceInBuffer() {

	}

	public NotEnoughSpaceInBuffer(String message) {
		super(message);
	}
}
