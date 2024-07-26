package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// This annotation indicates that the class is a repository.
@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
}

