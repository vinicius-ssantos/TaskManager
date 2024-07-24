package io.viniciussantos.task;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Logger;


import java.util.List;


@ApplicationScoped
@RequiredArgsConstructor
public class TaskService {
    @Inject
    TaskRepository taskRepository;

    @Inject
    TaskMapper taskMapper;

    private static final Logger log = Logger.getLogger(TaskService.class);

    public List<Task> listAll() {
        return taskRepository.list("order by creationDate desc");
    }

    @Transactional
    public Task create(TaskRequest taskRequest) {
        log.info("Creating task: {}");
        Task task = taskMapper.toTask(taskRequest);
        task.setStatus(Status.PENDING.getStatus());
        taskRepository.persist(task);
        return task;
    }

    @Transactional
    public Task update(Long id, TaskRequest taskRequest) {
        Task taskDB = taskRepository.findById(id);
        if (taskDB != null) {
            log.info("Updating task: " + taskRequest);
            taskMapper.updateTaskFromRequest(taskRequest, taskDB);
        }
        return taskDB;
    }

    @Transactional
    public void delete(Long id) {
        log.info("Deleting task with id: {}");
        taskRepository.deleteById(id);
    }
}
