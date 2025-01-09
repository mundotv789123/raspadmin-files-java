package github.mundotv789123.raspadmin.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import github.mundotv789123.raspadmin.models.messages.responses.ErrorResponse;

@ControllerAdvice
public class CustomValidatorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        @NonNull MethodArgumentNotValidException ex, 
        @NonNull HttpHeaders headers, 
        @NonNull HttpStatusCode status, 
        @NonNull WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
            .map(x -> x.getField() + " " + x.getDefaultMessage()).collect(Collectors.toList());

        String message = String.join("; ", errors);
        return ResponseEntity.status(status).headers(headers).body(new ErrorResponse(message));
    }
    
}
