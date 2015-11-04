package org.sample.service;

public class TwitterMessage implements Message {

	@Override
	public boolean sendMessage(String msg, String too) {

		System.out.println("Sending twitter msg"+msg);
		return false;
	}

}
