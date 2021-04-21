package com.estdois.leriando.persistence;


import com.estdois.leriando.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    /*public class BuscarComentarios{
        Post post = new Post();
        ComentarioRepository.
    }}*/
}
