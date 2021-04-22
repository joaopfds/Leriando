package com.estdois.leriando.persistence;

import com.estdois.leriando.entity.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
    @Query("SELECT c FROM Comentario c join Post p on (c.post = p)")
    List<Comentario> findComentarios();
}
