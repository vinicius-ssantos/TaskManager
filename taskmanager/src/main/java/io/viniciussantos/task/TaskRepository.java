package io.viniciussantos.task;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {
    // Custom query methods if needed


}
