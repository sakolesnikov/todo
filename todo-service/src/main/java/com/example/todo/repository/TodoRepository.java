package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {
}
