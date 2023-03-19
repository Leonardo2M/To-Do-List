package br.com.todolist.list.controller;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    //    @GetMapping
//    public List<Task> list() {
//        return Arrays.asList(new Task(2L, "task 2", null, new User()), new Task(1L, "task 1", null, new User()));
//    }
//
    @PostMapping
    public ResponseEntity<Task> addNewTask(@RequestBody Task data) {
        return service.addTask(data);
    }

}
