package com.example.todo.service;

import com.example.todo.coverter.TodoConverter;
import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoConverter todoConverter;

    public TodoDto save(TodoDto todoDto) {
        Todo todo = todoConverter.convertToTodo(todoDto);
        todo = todoRepository.save(todo);
        return todoConverter.convertToDto(todo);
    }

    public List<TodoDto> findAll() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false)
                .map(todoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        todoRepository.deleteById(id);
    }

    public TodoDto update(UUID id, TodoDto todo) {
        todo.setId(id);
        return save(todo);
    }

    public TodoDto findById(UUID id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        return todoConverter.convertToDto(todo);
    }
}
