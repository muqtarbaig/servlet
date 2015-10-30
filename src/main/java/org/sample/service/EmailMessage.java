package org.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmailMessage implements Message {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailMessage.class);
	@Override
	public boolean sendMessage(String msg, String to) {

		LOGGER.info("Email sent : "+msg+" to "+to);
		return false;
	}

}
