package com.hubService.Service;


import com.hubService.Model.Task;

public interface TaskService  {

    public Task createTask(String applicationId, Task task);
}
