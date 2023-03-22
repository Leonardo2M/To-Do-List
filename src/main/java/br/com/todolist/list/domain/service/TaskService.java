package br.com.todolist.list.domain.service;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Task> addTask(Task data){
        var task = new Task(null, data.getDescription(), null, LocalDateTime.now(),null);
        repository.save(task);
        return ResponseEntity.ok().body(task);
    }

    public ResponseEntity<List<Task>> listTasks(Long userId) {
        var tasks = repository.findAllByUserIdAndCompletedIsNull(userId);
        return ResponseEntity.ok().body(tasks);
    }
}
