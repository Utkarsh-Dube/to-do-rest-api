package com.example.Todo;

public class Todo {
    private Long id;
    private String task;
    private boolean completed;

    public Todo(Long id, String task,boolean completed)
    {
        this.id = id;
        this.task = task;
        this.completed = completed;

    }
    public Long getId()
    {
        return id;
    }
    public String getTask()
    {
        return task;
    }
    public boolean isCompleted()
    {
        return completed;
    }
    public void setId(Long newId)
    {
        id = newId;
    }
    public void setTask(String newTask)
    {
        task = newTask;

    }
    public void setCompleted(boolean newCompleted)
    {
        completed = newCompleted;
    }
}
