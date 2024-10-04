package epam.com.example.Second_Spring_Boot_Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(

                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "PRODUCT_NOT_FOUND"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NameAlreadyExistException.class})
    public ResponseEntity<ErrorDetails> handleNameAlreadyExistException(NameAlreadyExistException exception, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(

                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "PRODUCT_NAME_ALREADY_EXIST"
        );

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);

    }


}