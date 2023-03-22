package br.com.todolist.list.controller;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.service.TaskService;
import br.com.todolist.list.dto.task.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> list(@PathVariable Long userId) {
        return service.listTasks(userId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<TaskDTO> addNewTask(@RequestBody Task data, @PathVariable Long userId, UriComponentsBuilder uri) {
        return service.addTask(data, userId, uri);
    }

}
