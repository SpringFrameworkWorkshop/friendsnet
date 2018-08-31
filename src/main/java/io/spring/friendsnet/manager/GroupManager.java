package io.spring.friendsnet.manager;

import io.spring.friendsnet.entity.Person;
import io.spring.friendsnet.entity.Group;

public interface GroupManager extends Manager<Group, Long> {

    Iterable<Person> getByPersonId(Long personId);
}
