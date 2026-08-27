package com.example.Todo;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos()
    {
        return todoService.getAllTodo();

    }
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo)
    {
        return todoService.createTodo(todo);
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id)
    {
        Optional <Todo> todo = todoService.getTodoById(id);

        if(todo.isPresent())
            return ResponseEntity.ok(todo.get());
        else {
            return ResponseEntity.notFound().build();

        }

    }
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id)
    {
        if(todoService.deleteId(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id,@RequestBody Todo todo)
    {
        Optional<Todo> updated = todoService.updateTodo(id,todo);
        if(updated.isPresent())
            return ResponseEntity.ok(updated.get());
        else
            return ResponseEntity.notFound().build();
    }



}
