package org.sample.controller;

import org.muqtar.vo.Playmanifest;
import org.muqtar.vo.Playmanifest.Channels;
import org.muqtar.vo.Playmanifest.Channels.Channel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {

	@RequestMapping(value = "/play/xml", method = RequestMethod.GET)
	public Playmanifest getXml(){
		
		Playmanifest pm = new Playmanifest();
		Channel c = new Channel();
		c.setId("cid");
		c.setSystemId("abcdef");
		
		Channels cs = new Channels();
		cs.setChannel(c);
		
		pm.setChannels(cs);
		
		return pm;
	}
}
