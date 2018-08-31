package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Group;
import io.spring.friendsnet.entity.Person;

public interface GroupDAO extends EntityDAO<Group, Long>  {

    Group addPersons(Iterable<Person> persons);

    Iterable<Person> getByPersonId(Long personId);

}
