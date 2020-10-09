package com.atmecs.phptravels.testscripts;

import org.testng.annotations.Test;

import com.atmecs.phptravels.pages.ChatClass;
import com.atmecs.phptrtavels.testsuit.BaseTest;

public class ChatTest extends BaseTest {
	@Test
	public void runPhpTravels() throws InterruptedException {
		ChatClass obj = new ChatClass();
		obj.Chatbot();

	}
}
