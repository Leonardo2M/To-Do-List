package br.com.todolist.list.domain.service;

import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<User>> findAll() {
        var user = repository.findAll();

        return ResponseEntity.ok().body(user);
    }
}
