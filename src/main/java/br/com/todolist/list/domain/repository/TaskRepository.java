package br.com.todolist.list.domain.repository;

import br.com.todolist.list.domain.model.Task;
import br.com.todolist.list.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserIdAndCompletedIsFalse(Long userId);
    Optional<Task> findByIdAndCompletedIsFalse(Long id);
}
