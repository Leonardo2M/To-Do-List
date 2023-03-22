package br.com.todolist.list.domain.service;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.repository.TaskRepository;
import br.com.todolist.list.domain.repository.UserRepository;
import br.com.todolist.list.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Task> addTask(Task data, Long userId, UriComponentsBuilder uriBuilder){
        var user = userRepository.findById(userId).orElseThrow(() -> new UserException("id " + userId + " not found!"));
        var task = new Task(null, data.getDescription(), null, LocalDateTime.now(), user);
        var uri = uriBuilder.path("todo/{id}").buildAndExpand(task.getId()).toUri();
        repository.save(task);
        return ResponseEntity.created(uri).body(task);
    }

    public ResponseEntity<List<Task>> listTasks(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new UserException("id " + userId + " not found!");
        }
        var tasks = repository.findAllByUserIdAndCompletedIsFalse(userId);
        return ResponseEntity.ok().body(tasks);
    }
}
