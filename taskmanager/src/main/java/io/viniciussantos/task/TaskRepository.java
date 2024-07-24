package io.viniciussantos.task;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {
    // Custom query methods if needed


}
