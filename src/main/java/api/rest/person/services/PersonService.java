package api.rest.person.services;

import api.rest.person.dtos.requests.PersonDTO;
import api.rest.person.dtos.responses.ResponseMessageDTO;
import api.rest.person.entities.Person;
import api.rest.person.exceptions.PersonNotFoundException;
import api.rest.person.mappers.PersonMapper;
import api.rest.person.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    private PersonMapper personMapper = PersonMapper.INSTANCE;

    public ResponseMessageDTO createPerson(PersonDTO personDTO) {
        Person personToBeSaved = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToBeSaved);
        return createResponseMessage("Person created successfully! ID: ", savedPerson.getId());
    }

    private ResponseMessageDTO createResponseMessage(String message, Long id) {
        return ResponseMessageDTO.builder().message(message + id).build();
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public ResponseMessageDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToBeUpdated = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToBeUpdated);
        return createResponseMessage("Person updated successfully! ID: ", updatedPerson.getId());
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }
}
