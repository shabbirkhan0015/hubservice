package com.hubService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoredTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private String parentTask;
    private String taskName;
    private String childTask;
    private String taskType;
}