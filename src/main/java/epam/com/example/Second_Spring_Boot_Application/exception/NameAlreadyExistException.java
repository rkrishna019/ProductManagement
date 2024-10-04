package epam.com.example.Second_Spring_Boot_Application.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST )
public class NameAlreadyExistException extends RuntimeException{

   private  String message;
     public  NameAlreadyExistException(String message){
         super(message);
     }
}
