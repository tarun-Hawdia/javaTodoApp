package com.example.todo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// This annotation marks the class as a MongoDB document.
@Document(collection = "todos")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
@NoArgsConstructor // Lombok annotation to generate a no-arguments constructor.
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields.
public class Todo {

    // This annotation marks the field as the primary key.
    @Id
    private String id;
    private String title;
    private String description;
    private boolean completed;
}

