package github.mundotv789123.raspadmin.handlers;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import github.mundotv789123.raspadmin.models.responses.ErrorResponse;
import github.mundotv789123.raspadmin.services.exceptions.InvalidOperateServiceException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidOperateServiceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOperateServiceException(InvalidOperateServiceException ex, WebRequest request) {
        var errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(ex.getCode()).body(errorResponse);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFileNotFoundException(FileNotFoundException ex, WebRequest request) {
        var errorResponse = new ErrorResponse("Arquivo não foi encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        var errorResponse = new ErrorResponse("Ocorreu um erro interno");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
