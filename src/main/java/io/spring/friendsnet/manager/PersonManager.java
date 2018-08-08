package io.spring.friendsnet.manager;

import io.spring.friendsnet.entity.Person;

public interface PersonManager extends Manager<Person, Long> {


    Person relatePersons(Long personId, Iterable<Long> persons);
}
