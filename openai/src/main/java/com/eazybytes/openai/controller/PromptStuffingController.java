package com.eazybytes.openai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PromptStuffingController {

	private ChatClient chatClient;
	
	public PromptStuffingController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@Value("classpath:/promptTemplates/systemPromptTemplate.st")
	Resource systemTemplate;
	
	 @GetMapping("/prompt-stuffing")
	    public String promptStuffing(@RequestParam("message") String message) {
		 
		 return chatClient.prompt().system(systemTemplate).user(message).call().content();
		 
	 }
}
