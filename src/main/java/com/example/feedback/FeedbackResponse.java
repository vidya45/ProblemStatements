package com.example.feedback;

public class FeedbackResponse {
	
	private String messageToUser;

	public void setMessage(String message) {
		this.messageToUser = message;
	}
	
	public String getMessage() {
		return messageToUser;
		}

}
