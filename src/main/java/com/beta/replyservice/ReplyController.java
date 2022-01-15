package com.beta.replyservice;

import com.beta.error.InvalidInputException;
import com.beta.helper.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) throws NoSuchAlgorithmException, InvalidInputException {
		return replyService.reply(message);
	}

	/**
	 * This method will return the status 400 (Bad Request)
	 * with message "Invalid input" for the requests which
	 * contains the invalid input.
	 * @param e
	 * @return
	 */
	@ExceptionHandler(InvalidInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ReplyMessage handleException(InvalidInputException e) {
		return new ReplyMessage(e.getMessage());
	}
}