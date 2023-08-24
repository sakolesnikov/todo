package com.example.todo;

import com.example.todo.dto.TodoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.StringUtils;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save() throws Exception {
        TodoDto dto = postTodo("my title", "my description");
        assertThat(dto.getId()).isNotNull();
        TodoDto savedDto = getTodo(dto.getId());
        checkFields(dto, savedDto);
    }

    @Test
    public void update() throws Exception {
        TodoDto dto = postTodo("my title", "my description");
        assertThat(dto.getId()).isNotNull();
        dto.setTitle("my new title");
        checkFields(dto, putTodo(dto));
    }

    @Test
    public void delete() throws Exception {
        TodoDto dto = postTodo("my title", "my description");

        mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/todos/{id}", dto.getId())
                )
                .andExpect(status().isNoContent());
        assertThat(getTodo(dto.getId())).isNull();
    }

    private TodoDto getTodo(UUID id) throws Exception {
        String json = mockMvc.perform(get("/api/todos/{id}", id))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        if (StringUtils.hasText(json)) {
            return objectMapper.readValue(json, TodoDto.class);
        }
        return null;
    }

    private TodoDto putTodo(TodoDto dto) throws Exception {
        String json = mockMvc.perform(
                        put("/api/todos/{id}", dto.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))

                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        return objectMapper.readValue(json, TodoDto.class);
    }

    private TodoDto postTodo(String title, String description) throws Exception {
        TodoDto dto = TodoDto.builder().title(title).description(description).build();
        String json = mockMvc.perform(
                        post("/api/todos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        return objectMapper.readValue(json, TodoDto.class);
    }

    private void checkFields(TodoDto source, TodoDto dest) {
        assertThat(source.getId()).isEqualTo(dest.getId());
        assertThat(source.getTitle()).isEqualTo(dest.getTitle());
        assertThat(source.getDescription()).isEqualTo(dest.getDescription());
    }
}
