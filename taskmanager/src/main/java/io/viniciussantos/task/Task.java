package io.viniciussantos.task;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;
    @Column(insertable = false)
    private LocalDateTime completionDate;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        completionDate = LocalDateTime.now();
    }
}
