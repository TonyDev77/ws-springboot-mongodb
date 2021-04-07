package com.tony.workshopmongo.resources.exception;

import com.tony.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                OffsetDateTime.now(),
                status.value(),
                "Não encontrado",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(standardError);
    }
}
