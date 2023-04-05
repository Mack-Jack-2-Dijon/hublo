package Projet3.hublo.Tools;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
