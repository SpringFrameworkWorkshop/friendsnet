package io.spring.friendsnet.manager;

import io.spring.friendsnet.dao.PersonDAO;
import io.spring.friendsnet.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonManagerImpl implements PersonManager {


    @Autowired
    private PersonDAO dao;


    @Override
    public Person relatePersons(Long personId, Iterable<Long> newFriendIds) {
        Person person = dao.findById(personId);
        final Set<Person> personSet = StreamSupport.stream(newFriendIds.spliterator(), false)
                .map(dao::findById).collect(Collectors.toSet());
        person.getChildren().addAll(personSet);
        return dao.save(person);
    }

    @Override
    public Iterable<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public Person findById(Long aLong) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return dao.save(person);
    }

    @Override
    public Iterable<Person> save(Iterable<Person> people) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public Iterable<Person> update(Iterable<Person> people) {
        return null;
    }

    @Override
    public void remove(Long id) {
        dao.remove(dao.findById(id));
    }
}
