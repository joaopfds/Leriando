package com.estdois.leriando.persistence;


import com.estdois.leriando.entity.Comentario;
import com.estdois.leriando.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT c.text FROM Comentario c  ")
    List<String> findComentarios();
}
