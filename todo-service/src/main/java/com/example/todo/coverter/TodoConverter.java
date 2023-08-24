package com.example.todo.coverter;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TodoConverter {
    public Todo convertToTodo(TodoDto todoDto) {
        if (todoDto == null) return null;
        Todo todo = new Todo();
        todo.setId(UUID.randomUUID());
        BeanUtils.copyProperties(todoDto, todo);
        return todo;
    }

    public TodoDto convertToDto(Todo todo) {
        if (todo == null) return null;
        TodoDto dto = new TodoDto();
        BeanUtils.copyProperties(todo, dto);
        return dto;
    }
}
