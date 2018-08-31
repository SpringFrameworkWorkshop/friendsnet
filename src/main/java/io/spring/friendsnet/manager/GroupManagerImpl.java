package io.spring.friendsnet.manager;

import io.spring.friendsnet.dao.GroupDAO;
import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupManagerImpl implements GroupManager {


    @Autowired
    private GroupDAO dao;


    @Override
    public Iterable<Group> findAll() {
        return dao.findAll();
    }

    @Override
    public Group findById(Long aLong) {
        return null;
    }

    @Override
    public Group save(Group person) {
        return dao.save(person);
    }

    @Override
    public Iterable<Group> save(Iterable<Group> people) {
        return null;
    }

    @Override
    public Group update(Group person) {
        return null;
    }

    @Override
    public Iterable<Group> update(Iterable<Group> people) {
        return null;
    }

    @Override
    public void remove(Long id) {
        final Group group = dao.findById(id);
        dao.remove(group);
    }

    @Override
    public Iterable<Person> getByPersonId(Long personId) {
        return dao.getByPersonId(personId);
    }
}
