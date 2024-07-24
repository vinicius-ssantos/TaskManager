package io.viniciussantos.task;

public record TaskRequest (
        Long id,
        String title,
        String description,
        String status,
        String creationDate,
        String completionDate
){

}
