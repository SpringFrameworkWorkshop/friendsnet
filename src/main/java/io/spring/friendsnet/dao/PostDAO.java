package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Like;
import io.spring.friendsnet.entity.Post;

public interface PostDAO extends EntityDAO<Post, Long>  {

    Post addLike(Like like);
}
