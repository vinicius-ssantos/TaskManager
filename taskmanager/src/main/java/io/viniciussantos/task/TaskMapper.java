package io.viniciussantos.task;

public class TaskMapper {
    public Task toTask(TaskRequest taskRequest) {
       return Task.builder()
               .id(taskRequest.id())
                .title(taskRequest.title())
                .description(taskRequest.description())
                .status(taskRequest.status())
                .build();
    }

    public TaskResponse toTaskResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }
}
