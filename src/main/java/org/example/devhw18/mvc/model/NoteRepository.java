package org.example.devhw18.mvc.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("FROM Note n where n.content like :query or n.title like :query")
    List<Note> search(@Param("query") String query);
    @Transactional
    @Modifying
    @Query("DELETE FROM Note n where n.content like :query or n.title like :query")
    void delete(@Param("query") String query);

    @Transactional
    @Modifying
    @Query("UPDATE Note n SET n.title =:title, n.content =:content WHERE n.id=:id")
    void update(@Param("id") Long id, @Param("title") String title, @Param("content")String content);

}
