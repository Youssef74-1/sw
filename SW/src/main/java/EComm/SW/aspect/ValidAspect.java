package EComm.SW.aspect;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidAspect {


    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<?> resolveException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String message = "";
        for (FieldError error : fieldErrors) {
            message = message.concat(error.getField()+" "+error.getDefaultMessage()+" ");
        }
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

    }


}

