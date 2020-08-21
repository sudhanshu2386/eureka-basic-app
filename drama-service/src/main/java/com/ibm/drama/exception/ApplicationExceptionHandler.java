package com.ibm.drama.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.drama.model.DramaException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = DramaException.class)
	public ResponseEntity<DramaException> handleGenericException(DramaException ae) {
		DramaException actorException = new DramaException(100, "Generic Data invalid !!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(actorException);
	}
}
