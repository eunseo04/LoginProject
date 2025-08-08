package org.example.todoweb.Repository;

import org.example.todoweb.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
}
