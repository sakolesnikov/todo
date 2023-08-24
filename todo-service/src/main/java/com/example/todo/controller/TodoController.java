package com.example.todo.controller;

import com.example.todo.api.TodoApi;
import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TodoController implements TodoApi {

    private final TodoService todoService;

    @Override
    public List<TodoDto> findAll() {
        return todoService.findAll();
    }

    @Override
    public TodoDto findById(UUID id) {
        return todoService.findById(id);
    }

    @Override
    public TodoDto save(TodoDto todo) {
        return todoService.save(todo);
    }

    @Override
    public TodoDto update(UUID id, TodoDto todo) {
        return todoService.update(id, todo);
    }

    @Override
    public void delete(UUID id) {
        todoService.delete(id);
    }
}
