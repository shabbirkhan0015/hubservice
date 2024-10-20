package com.hubService.Service.impl;

import com.hubService.Model.Task;
import com.hubService.Repository.TaskRepository;
import com.hubService.Service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    @Override
    public Task createTask(String applicationId, Task task) {
        task.setApplicationId(applicationId);
        return taskRepository.save(task);
    }
}
