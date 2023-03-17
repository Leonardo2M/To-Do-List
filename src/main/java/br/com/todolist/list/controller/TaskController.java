package br.com.todolist.list.controller;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {

    @GetMapping
    public List<Task> list() {
        return Arrays.asList(new Task(2L, "task 2", new User()), new Task(1L, "task 1", new User()));
    }

    @PostMapping
    public Task addNewTask(@RequestBody Task task) {
        System.out.println(task.getDescription());
        return new Task(task.getId(), task.getDescription(), task.getUser());
    }

}
