package ch.bbw.services;

import ch.bbw.entities.Person;
import ch.bbw.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            personList.add(person);
        }
        return personList;
    }
}
