package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This annotation indicates that the class is a service component in the Spring context.
@Service
public class TodoService {

    // Injecting the TodoRepository to interact with MongoDB.
    @Autowired
    private TodoRepository todoRepository;

    // Method to retrieve all todo items from the database.
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Method to retrieve a specific todo item by its ID.
    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    // Method to create a new todo item or update an existing one.
    public Todo createOrUpdateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Method to delete a specific todo item by its ID.
    public void deleteTodoById(String id) {
        todoRepository.deleteById(id);
    }
}

