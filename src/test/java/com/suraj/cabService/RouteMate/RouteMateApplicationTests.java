package com.suraj.cabService.RouteMate;

import com.suraj.cabService.RouteMate.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RouteMateApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail(
				"biswalsuraj906@gmail.com",
				"This is the testing email",
				"Body of my email"
		);
	}

}
