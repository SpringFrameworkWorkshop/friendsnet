package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventDAOImpl extends AbstractDAO<Event, Long> implements EventDAO {
}
