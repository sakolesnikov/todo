package com.example.todo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "TODO Service REST API",
                description = """
                        The TODO Project REST API is a powerful and flexible tool designed 
                        to manage tasks and to-do lists within projects. 
                        It allows developers to seamlessly integrate task management capabilities 
                        into their applications, enabling users to create, update, delete, 
                        and retrieve tasks in a project-centric manner. 
                        
                        This API follows the principles of Representational State Transfer (REST) 
                        for easy integration and consistent interaction.
                        """,
                contact = @Contact(
                        name = "Author Name",
                        url = "http://website.com",
                        email = "authorname@gmail.com"
                )
        )
)
class OpenAPIConfig {
}