package epam.com.example.Second_Spring_Boot_Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private  String resouceName;
    private String fieldName;
    private Integer fieldValue;

    public ResourceNotFoundException(String resouceName,String fieldName, Integer fieldValue){

        super(String.format("%s not found with %s : '%s' ",resouceName,fieldName,fieldValue));
        this.resouceName = resouceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
