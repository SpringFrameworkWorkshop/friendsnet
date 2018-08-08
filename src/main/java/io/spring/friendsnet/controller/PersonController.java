package io.spring.friendsnet.controller;

import io.spring.friendsnet.controller.domain.CreatePersonDTO;
import io.spring.friendsnet.controller.domain.PersonDTO;
import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.manager.PersonManager;
import io.spring.friendsnet.utils.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonManager manager;

    @Autowired
    private EntityConverter entityConverter;

    @GetMapping
    public List<PersonDTO> getAll(){
        List<Person> personList = (List<Person>) manager.findAll();
        return entityConverter.convert(personList, PersonDTO.class);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public Person create(@RequestBody CreatePersonDTO personDTO){
        final Person person = entityConverter.convert(personDTO, Person.class);
        return manager.save(person);
    }

    @PostMapping("/{id}/relate")
    public Person relate(@PathVariable Long id, @RequestBody List<Long> persons){
        return this.manager.relatePersons(id, persons);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        manager.remove(id);
    }
}
