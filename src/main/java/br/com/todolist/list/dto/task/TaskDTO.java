package br.com.todolist.list.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String description;
    private Boolean completed;
    private LocalDateTime date = LocalDateTime.now();
}
