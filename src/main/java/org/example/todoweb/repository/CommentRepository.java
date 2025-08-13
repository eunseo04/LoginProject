package org.example.todoweb.repository;

import org.example.todoweb.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
     List<CommentEntity> findByUserId(Long userId);
}
