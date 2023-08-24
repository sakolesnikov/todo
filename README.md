# TODO API - README

The TODO API is a service that allows you to manage your TODO list. It provides endpoints to create, retrieve, update, and delete TODO items.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Running the Project Locally](#running-the-project-locally)
- [Building and Deploying Docker Image](#building-and-deploying-docker-image)
- [API Endpoints](#api-endpoints)
    - [Create a TODO Item](#create-a-todo-item)
    - [Get All TODO Items](#get-all-todo-items)
    - [Get a TODO Item](#get-a-todo-item)
    - [Update a TODO Item](#update-a-todo-item)
    - [Delete a TODO Item](#delete-a-todo-item)

## Getting Started

There are two modules:

- todo-api
- todo-service

**todo-api** - The **API** module acts as the interface through which external entities, 
such as other applications or users, can interact with your service. It provides a set of 
well-defined endpoints that allow consumers to send requests and receive responses. 
This module focuses on the communication protocol, data formats, and the overall 
structure of the interactions.

**todo-service** - The **Service** module contains the actual code that makes our 
service work. It includes the detailed logic, algorithms, database interactions, and any other 
technical aspects required to fulfill the functionalities defined in the API module. 

### Prerequisites

Before running the TODO API, make sure you have the following installed:

- OpenJDK 20
- Docker (for optional containerization)

### Running the Project Locally

   ```bash
   cd todo-service
   mvn spring-boot:run
   ```
Go to http://localhost:8080/swagger-ui/index.html and you will be prompted for 
the login and password of your GitHub account.

### Building and Deploying Docker Image

1. Build the Docker image:

  ```bash
  docker build -t todo-service:latest .
  ```
  Make sure that our todo-service is included in the list
  ```bash
   docker image ls
  ```

2. Run a Docker container from the built image:
  ```bash
   docker run --name todo-service -p 8080:8080 -d todo-service
  ```

## API Endpoints

OAuth2 settings are not included.

### Create a TODO Item

The **Create** operation refers to the process of adding new data to a system.

   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{
    "title": "title0",
    "description": "description0"
  }' http://example.com/api/todos
   ```
### Get All TODO Items

To retrieve a list of all TODOs using the HTTP GET method, you can use the `curl` command as shown below. In this example, we are sending a GET request to the specified URL:
```bash
curl http://example.com/api/todos
```

### Get a TODO Item
To retrieve a specific todo item using the HTTP GET method:

```bash
curl http://example.com/api/todos/{id}
```

### Update a TODO Item


```bash
curl -X PUT -H "Content-Type: application/json" -d '{
  "id": "400f69c8-282a-40af-a8d5-e9ec2b7d4287",
  "title": "Updated Todo Title",
  "description": "Updated description for the todo"
}' http://example.com/api/todos/{id}
```

### Delete a TODO Item

To delete a specific todo item using the HTTP DELETE method:

```bash
curl -X DELETE http://example.com/api/todos/{id}
```
