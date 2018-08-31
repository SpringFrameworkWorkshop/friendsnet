package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Group;
import io.spring.friendsnet.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class GroupDAOImpl extends AbstractDAO<Group, Long> implements GroupDAO {
    @Override
    public Group addPersons(Iterable<Person> persons) {
        return null;
    }

    public Iterable<Person> getByPersonId(Long personId) {
        return null;
    }
}
