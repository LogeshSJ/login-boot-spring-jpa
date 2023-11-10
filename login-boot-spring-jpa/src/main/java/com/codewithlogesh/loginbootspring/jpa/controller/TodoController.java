package com.codewithlogesh.loginbootspring.jpa.controller;

import com.codewithlogesh.loginbootspring.jpa.model.Todo;
import com.codewithlogesh.loginbootspring.jpa.request.TodoRequest;
import com.codewithlogesh.loginbootspring.jpa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
//    private List<Todo> todos;

    @GetMapping("/all/{userId}")
    public List<Todo> getAllTodos(@PathVariable int userId) {

        return todoService.findAll(userId);
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody TodoRequest todo) {

        return todoService.insert(todo);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo) {

        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodoById(@PathVariable Integer id) {

        return todoService.delete(id);
    }
}
