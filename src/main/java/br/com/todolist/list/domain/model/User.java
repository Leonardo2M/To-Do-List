package br.com.todolist.list.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany
    private List<Task> tasks;
}