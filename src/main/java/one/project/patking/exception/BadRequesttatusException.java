package one.project.patking.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus (HttpStatus.BAD_REQUEST)
public class BadRequesttatusException extends  RuntimeException{
    public BadRequesttatusException(String message) {
        super(message);
    }
}
