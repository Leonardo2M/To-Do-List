package br.com.todolist.list.domain.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class User {

    private Long id;
    private String username;
    private String password;

    private List<Task> tasks;
}