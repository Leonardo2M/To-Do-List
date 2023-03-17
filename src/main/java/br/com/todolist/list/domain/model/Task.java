package br.com.todolist.list.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Task {

    private Long id;
    private String description;


}
