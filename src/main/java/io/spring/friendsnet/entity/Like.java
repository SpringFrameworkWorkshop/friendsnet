package io.spring.friendsnet.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Like implements FNEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Date creationDate;
    private LikeType type;
}
