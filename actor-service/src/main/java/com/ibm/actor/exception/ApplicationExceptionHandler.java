package com.ibm.actor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.actor.model.ActorException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = ActorException.class)
	public ResponseEntity<ActorException> handleGenericException(ActorException ae) {
		ActorException actorException = new ActorException(100, "Generic Data invalid !!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(actorException);
	}
}
