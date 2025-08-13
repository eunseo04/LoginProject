package org.example.todoweb.repository;

import org.example.todoweb.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    List<TodoEntity> findByUserEntityId(Long userId);
}
