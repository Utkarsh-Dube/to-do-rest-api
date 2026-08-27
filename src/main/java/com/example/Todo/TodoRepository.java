package com.example.Todo;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TodoRepository {
    private final  List<Todo> todos = new ArrayList<>();
    private Long nextId = 1L;

    public List<Todo> findAll()
    {
        return todos;
    }
    public Todo savetodo(Todo todo)
    {
        todo.setId(nextId++);
        todos.add(todo);
        return todo;
    }

    public Optional<Todo> findById(Long id)
    {
        for(Todo todo :todos)
        {
            if(todo.getId().equals(id))
                return Optional.of(todo);
        }
        return Optional.empty();
    }

    public boolean deleteId(Long id)
    {
        for(Todo todo: todos) {
            if (todo.getId().equals(id)) {
                todos.remove(todo);
                return true;

            }
        }

        return false;
    }

    public Optional<Todo> update(Long id,Todo updatedTodo)
    {
        for(Todo todo : todos)
        {
            if(todo.getId().equals(id))
            {
                todo.setTask(updatedTodo.getTask());
                todo.setCompleted(updatedTodo.isCompleted());
                return Optional.of(todo);
            }
        }
        return Optional.empty();
    }



}
