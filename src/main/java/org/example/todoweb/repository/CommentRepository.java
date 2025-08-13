package org.example.todoweb.repository;

import org.example.todoweb.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
     List<CommentEntity> findByTodoEntity_UserEntity_Id(Long userId);
     List<CommentEntity> findByTodoEntity_Id(Long commentId);
}
