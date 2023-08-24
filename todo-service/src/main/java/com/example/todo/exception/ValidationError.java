package com.example.todo.exception;

record ValidationError(String field, String message) {}
