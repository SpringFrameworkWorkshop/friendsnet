package io.spring.friendsnet.manager;

import io.spring.friendsnet.dao.GroupDAO;
import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.entity.PersonGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupManagerImpl implements GroupManager {


    @Autowired
    private GroupDAO dao;


    @Override
    public Iterable<PersonGroup> findAll() {
        return dao.findAll();
    }

    @Override
    public PersonGroup findById(Long aLong) {
        return null;
    }

    @Override
    public PersonGroup save(PersonGroup person) {
        return dao.save(person);
    }

    @Override
    public Iterable<PersonGroup> save(Iterable<PersonGroup> people) {
        return null;
    }

    @Override
    public PersonGroup update(PersonGroup person) {
        return null;
    }

    @Override
    public Iterable<PersonGroup> update(Iterable<PersonGroup> people) {
        return null;
    }

    @Override
    public void remove(Long id) {
        final PersonGroup personGroup = dao.findById(id);
        dao.remove(personGroup);
    }

    @Override
    public Iterable<Person> getByPersonId(Long personId) {
        return dao.getByPersonId(personId);
    }
}
