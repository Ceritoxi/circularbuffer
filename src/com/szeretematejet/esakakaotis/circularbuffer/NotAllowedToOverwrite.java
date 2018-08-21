package com.szeretematejet.esakakaotis.circularbuffer;

public class NotAllowedToOverwrite extends RuntimeException {

	private static final long serialVersionUID = 1528964068818690546L;

	public NotAllowedToOverwrite() {

	}

	public NotAllowedToOverwrite(String massage) {
		super(massage);
	}
}
