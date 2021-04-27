/*
Company: WeDoCode.net
GitRepo: https://github.com/wedocodedotnet/javaspringboot
Author: Shaun Kiesewetter
Date: Saturday 14 March 2021
Component: Business Layer in classic n-tier architecture
*/
package net.wedocode.PeopleService.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Tell Spring Boot to create an instance of this class for dependency injection with the @Service attribute
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        return  personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        // Example of some business logic and yes it gets way more complex than this.
        if (personOptional.isPresent()){
            throw new IllegalStateException("This email has already been used");
        }

        personRepository.save(person);
        System.out.println(person);
    }

    public void deletePerson(Long id) {
        if (personRepository.existsById(id)){
            personRepository.deleteById(id);
        } else
        {
            throw new IllegalStateException("Person does not exist");
        }
    }


    @Transactional
    public void updatePerson(Long id, String name, String email) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalStateException(("Person does not exist")));
        if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)){
            person.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)){

            Optional<Person> personOptional = personRepository.findPersonByEmail(email);
            if (personOptional.isPresent()){
                throw new IllegalStateException("This email has already been used");
            }
            person.setEmail(email);
        }
    }
}
