package com.fbr.logging;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component("logging")
public class Logging {
	public void start() {
		System.out.println("method start running");
	}
	public void end() {
		System.out.println("method end running");
	}
}
