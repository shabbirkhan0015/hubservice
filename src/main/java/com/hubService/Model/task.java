package com.hubService.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class task {
    private String taskName;
    private String childTask;
    private Boolean childTaskStatus;
    private Boolean taskStatus;
    private String taskType;
}
