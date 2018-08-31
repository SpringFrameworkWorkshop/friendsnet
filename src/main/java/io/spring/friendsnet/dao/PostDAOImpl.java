package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.Like;
import io.spring.friendsnet.entity.Post;

public class PostDAOImpl extends AbstractDAO<Post, Long> implements PostDAO {

    @Override
    public Post addLike(Like like) {
        return null;
    }
}
