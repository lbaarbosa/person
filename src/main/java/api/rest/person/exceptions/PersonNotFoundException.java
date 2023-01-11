package api.rest.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception implements Serializable {

    public PersonNotFoundException(Long id) { super("Person not found! ID: " + id); }

}
