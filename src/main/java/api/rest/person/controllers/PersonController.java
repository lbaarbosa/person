package api.rest.person.controllers;

import api.rest.person.dtos.requests.PersonDTO;
import api.rest.person.dtos.responses.ResponseMessageDTO;
import api.rest.person.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessageDTO createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonDTO> listAll() { return personService.listAll(); }

    @PutMapping("/{id}")
    public ResponseMessageDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        personService.delete(id);
    }
}
