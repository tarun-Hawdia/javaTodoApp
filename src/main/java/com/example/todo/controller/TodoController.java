package com.example.todo.controller;


import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// This annotation marks the class as a REST controller.
@RestController
@RequestMapping("/todos")
public class TodoController {

    // Injecting the TodoRepository to interact with MongoDB.
    @Autowired
    private TodoRepository todoRepository;

    // Endpoint to create a new todo item.
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        // Saving the new todo item to the database.
        Todo savedTodo = todoRepository.save(todo);
        // Returning the saved todo item.
        return ResponseEntity.ok(savedTodo);
    }

    // Endpoint to retrieve all todo items.
    @GetMapping
    public List<Todo> getAllTodos() {
        // Returning all todo items from the database.
        return todoRepository.findAll();
    }

    // Endpoint to update an existing todo item.
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {

        // Finding the existing todo item by ID.
        Optional<Todo> optionalTodo = todoRepository.findById(id);


        if (optionalTodo.isPresent()) {

            // Updating the existing todo item with new details.
            Todo existingTodo = optionalTodo.get();
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());

            // Saving the updated todo item to the database.
            Todo savedTodo = todoRepository.save(existingTodo);

            // Returning the updated todo item.
            return ResponseEntity.ok(savedTodo);

        } else {
            // Returning a 404 Not Found status if the todo item is not found.
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a todo item.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {

        // Checking if the todo item exists before deleting.
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            // Deleting the todo item from the database.
            todoRepository.delete(optionalTodo.get());

            // Returning a 204 No Content status to indicate successful deletion.
            return ResponseEntity.noContent().build();
        } else {
            // Returning a 404 Not Found status if the todo item is not found.
            return ResponseEntity.notFound().build();
        }
    }
}

