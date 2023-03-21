package br.com.todolist.list.domain.service;

import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<User> createUser(User data, UriComponentsBuilder uriBuilder) {
        System.out.println(data.getUsername() + "  " + data.getPassword());
        var user = new User(null, data.getUsername(), data.getUsername(), null);
        var uri = uriBuilder.path("/user").buildAndExpand(user.getId()).toUri();
        repository.save(user);

        return ResponseEntity.created(uri).body(user);
    }

    public ResponseEntity<List<User>> findAll() {
        var user = repository.findAll();

        return ResponseEntity.ok().body(user);
    }



}
