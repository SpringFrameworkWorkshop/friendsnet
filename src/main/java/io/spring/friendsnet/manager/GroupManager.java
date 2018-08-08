package io.spring.friendsnet.manager;

import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.entity.PersonGroup;

public interface GroupManager extends Manager<PersonGroup, Long> {

    Iterable<Person> getByPersonId(Long personId);
}
