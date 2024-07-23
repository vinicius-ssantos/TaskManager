package io.viniciussantos.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;


import java.util.List;


@ApplicationScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.listAll();
    }

    @Transactional
    public Task create(Task task) {
        taskRepository.persist(task);
        return task;
    }

    @Transactional
    public Task update(Long id, Task task) {
        Task entity = taskRepository.findById(id);
        if (entity != null) {
            entity.setTitle(task.getTitle());
            entity.setDescription(task.getDescription());
            entity.setCompletionDate(task.getCompletionDate());
            entity.setStatus(task.getStatus());
        }
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
