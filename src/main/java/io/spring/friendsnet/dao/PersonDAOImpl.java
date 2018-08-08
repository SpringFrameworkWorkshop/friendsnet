package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonDAOImpl extends AbstractDAO<Person, Long> implements PersonDAO {
}
