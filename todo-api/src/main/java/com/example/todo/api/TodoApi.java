package com.example.todo.api;

import com.example.todo.dto.TodoDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/todos")
@Tag(name = "Todo API", description = "CRUD operations with TODO entities")
public interface TodoApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<TodoDto> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    TodoDto findById(@PathVariable UUID id);

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TodoDto save(@Valid @RequestBody TodoDto todo);

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    TodoDto update(@PathVariable UUID id, @Valid @RequestBody TodoDto todo);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);
}