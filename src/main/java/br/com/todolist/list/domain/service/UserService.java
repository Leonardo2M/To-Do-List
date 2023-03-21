package br.com.todolist.list.domain.service;

import br.com.todolist.list.domain.model.User;
import br.com.todolist.list.domain.repository.UserRepository;
import br.com.todolist.list.dto.user.CreateUserDTO;
import br.com.todolist.list.dto.user.UpdateUserDTO;
import br.com.todolist.list.dto.user.UserDTO;
import br.com.todolist.list.exception.UserException;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<UserDTO> createUser(CreateUserDTO data, UriComponentsBuilder uriBuilder) {
        var user = modelMapper.map(data, User.class);
        System.out.println(user.getId() + " " + user.getUsername() + " " + user.getPassword());
        var uri = uriBuilder.path("/user").buildAndExpand(user.getId()).toUri();
        repository.save(user);

        return ResponseEntity.created(uri).body(modelMapper.map(user, UserDTO.class));
    }

    public ResponseEntity<List<User>> findAll() {
        var user = repository.findAll();

        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity<UserDTO> updateUser(UpdateUserDTO updateData, Long id) {
        var user = repository.findById(id).orElseThrow(() -> new UserException("id " + id + " not found!"));
        user.update(updateData);
        repository.save(user);

        return ResponseEntity.ok().body(modelMapper.map(user, UserDTO.class));
    }


    public ResponseEntity<?> deleteUser(Long id) {
        var user = repository.findById(id).orElseThrow(() -> new UserException("id " + id + " not found!"));
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
