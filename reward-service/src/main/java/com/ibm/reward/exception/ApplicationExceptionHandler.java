package com.ibm.reward.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.reward.model.RewardException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = RewardException.class)
	public ResponseEntity<RewardException> handleGenericException(RewardException ae) {
		RewardException actorException = new RewardException(100, "Generic Data invalid !!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(actorException);
	}
}
