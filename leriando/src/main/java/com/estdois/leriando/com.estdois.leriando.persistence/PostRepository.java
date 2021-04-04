package com.estdois.leriando.com.estdois.leriando.persistence;


import com.estdois.leriando.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
