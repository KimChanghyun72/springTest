package com.yedam.app.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("tv")
public class LgTV implements TV {
	//@Autowired  //주입 factory.getBean("speaker")
	Speaker speaker;	 
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
