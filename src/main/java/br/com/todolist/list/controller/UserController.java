package br.com.todolist.list.controller;

import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.service.UserService;
import br.com.todolist.list.dto.user.CreateUserDto;
import br.com.todolist.list.dto.user.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDTO> create(@RequestBody CreateUserDto data, UriComponentsBuilder uri) {
        return service.createUser(data, uri);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return service.findAll();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<User> updateUser(@RequestBody User updateData) {
        return service.updateUser(updateData);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}
