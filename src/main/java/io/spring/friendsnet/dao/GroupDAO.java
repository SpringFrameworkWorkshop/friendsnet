package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.PersonGroup;
import io.spring.friendsnet.entity.Person;

public interface GroupDAO extends EntityDAO<PersonGroup, Long>  {

    PersonGroup addPersons(Iterable<Person> persons);

    Iterable<Person> getByPersonId(Long personId);

}
