package io.viniciussantos.task;

import jakarta.inject.Inject;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.listAll();
    }

    @POST
    public Task createTask(TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @PUT
    @Path("/{id}")
    public Task updateTask(@PathParam("id") Long id, TaskRequest taskRequest) {
        return taskService.update(id, taskRequest);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.delete(id);
    }
}
