package io.viniciussantos.task;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public Task createTask(Task task) {
        return taskService.create(task);
    }

    @PUT
    @Path("/{id}")
    public Task updateTask(@PathParam("id") Long id, Task task) {
        return taskService.update(id, task);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.delete(id);
    }
}
