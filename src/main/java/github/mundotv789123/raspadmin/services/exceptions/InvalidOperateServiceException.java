package github.mundotv789123.raspadmin.services.exceptions;

import org.springframework.http.HttpStatusCode;

import lombok.Getter;

public class InvalidOperateServiceException extends RuntimeException {
    private @Getter int code;
    
    public InvalidOperateServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public InvalidOperateServiceException(String message, HttpStatusCode code) {
        this(message, code.value());
    }
}
