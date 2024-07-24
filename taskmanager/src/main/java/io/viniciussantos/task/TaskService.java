package io.viniciussantos.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
@ApplicationScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.list("order by creationDate desc");
    }

    @Transactional
    public Task create(Task task) {
        log.info("Creating task: {}", task);
        taskRepository.persist(task);
        return task;
    }

    @Transactional
    public Task update(Long id, Task task) {
        Task entity = taskRepository.findById(id);
        if (entity != null) {
            log.info("Updating task: {}", task);
            entity.setTitle(task.getTitle());
            entity.setDescription(task.getDescription());
            entity.setCompletionDate(task.getCompletionDate());
            entity.setStatus(task.getStatus());
        }
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        log.info("Deleting task with id: {}", id);
        taskRepository.deleteById(id);
    }
}
