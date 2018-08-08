package io.spring.friendsnet.dao;

import io.spring.friendsnet.entity.PostLike;
import io.spring.friendsnet.entity.Post;

public interface PostDAO extends EntityDAO<Post, Long>  {

    Post addLike(PostLike postLike);
}
