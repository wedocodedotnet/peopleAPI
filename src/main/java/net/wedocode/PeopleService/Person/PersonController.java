/*
Company: WeDoCode.net
GitRepo:https://github.com/wedocodedotnet/javaspringboot
Author: Shaun Kiesewetter
Date: Saturday 14 March 2021
Component: API Layer in classic n-tier architecture
*/
package net.wedocode.PeopleService.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    //Dependency Injection
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long id){
        personService.deletePerson(id);
    }

    @PutMapping(path="{personId}")
    public void updatePerson(@PathVariable("personId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        personService.updatePerson(id, name, email);
    }
}
