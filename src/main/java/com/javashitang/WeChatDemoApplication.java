package com.javashitang;

import com.javashitang.view.MenuManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WeChatDemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeChatDemoApplication.class, args);
		MenuManager.createMenu();
	}
}
