package org.sample.service;

import org.springframework.stereotype.Component;

@Component
public interface Message {

	public boolean sendMessage(String msg, String too);
	
}
