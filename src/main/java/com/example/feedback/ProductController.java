package com.example.feedback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@RequestMapping(method = RequestMethod.POST, value = "/products/feedback")
	public FeedbackResponse registerFeedback(@RequestBody Product productFeedback) {
		FeedbackResponse feedback = new FeedbackResponse();
		boolean block = Boolean.FALSE;
		
		try(BufferedReader in = new BufferedReader(new FileReader("src/main/resources/ObjectionalWords"))){
		      String line;
				while((line = in.readLine())!=null){
					  if (productFeedback.getFeedback().contains(line)) {
							block = true;
							break;
						}  
				  }
		    } catch (IOException e1) {
				e1.printStackTrace();
			}
		if (block) {
			feedback.setMessage("Sorry !!! Objectionable content is not allowed.");
		} else {
			feedback.setMessage("Feedback registered !!! Thank you");
		}
		return feedback;
	}
}
