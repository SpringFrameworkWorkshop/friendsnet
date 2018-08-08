package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.PersonGroup;
import io.spring.friendsnet.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class GroupDAOImpl extends AbstractDAO<PersonGroup, Long> implements GroupDAO {
    @Override
    public PersonGroup addPersons(Iterable<Person> persons) {
        return null;
    }

    public Iterable<Person> getByPersonId(Long personId) {
        return null;
    }
}
