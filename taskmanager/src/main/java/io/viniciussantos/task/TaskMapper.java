package io.viniciussantos.task;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;


@ApplicationScoped
public class TaskMapper {
    public Task toTask(TaskRequest taskRequest) {
       return Task.builder()
               .id(taskRequest.id())
                .title(taskRequest.title())
                .description(taskRequest.description())
                .build();
    }

    public TaskResponse toTaskResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(String.valueOf(task.getStatus()))
                .build();
    }

    // Método adicional para atualizar a entidade Task a partir do TaskRequest
    public void updateTaskFromRequest(TaskRequest taskRequest,  Task task) {
        task.setTitle(taskRequest.title());
        task.setDescription(taskRequest.description());
        task.setStatus(taskRequest.status());
        if (taskRequest.status().equals(Status.COMPLETED.getStatus())) {
            task.setCompletionDate(LocalDateTime.now());
        }
    }
}
