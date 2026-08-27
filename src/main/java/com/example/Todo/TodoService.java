package com.example.Todo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodo()
    {
        return todoRepository.findAll();


    }
    public Todo createTodo(Todo todo)
    {
        return todoRepository.savetodo(todo);
    }

    public Optional<Todo> getTodoById(Long id)

    {
        return todoRepository.findById(id);
    }

    public boolean deleteId(Long id)
    {
        return todoRepository.deleteId(id);
    }

    public Optional<Todo> updateTodo(Long id, Todo todo)
    {
        return todoRepository.update(id,todo);
    }
}
