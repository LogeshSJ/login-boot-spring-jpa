package com.codewithlogesh.loginbootspring.jpa.service;

import com.codewithlogesh.loginbootspring.jpa.model.AppUser;
import com.codewithlogesh.loginbootspring.jpa.model.Todo;
import com.codewithlogesh.loginbootspring.jpa.repository.TodoRepository;
import com.codewithlogesh.loginbootspring.jpa.repository.UserRepository;
import com.codewithlogesh.loginbootspring.jpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> insert(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = userRepository.findById(todo.getUser_id()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUser_id());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = userRepository.findById(todo.getUser_id()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUser_id());
    }

    public List<Todo> delete(Integer id) {
        int userId = todoRepository.findById(id).get().getAppUser().getId();
        todoRepository.deleteById(id);
        return findAll(userId);
    }
}

