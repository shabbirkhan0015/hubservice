package com.hubService.Controller;


import com.hubService.Model.Task;
import com.hubService.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService)
    {
        this.taskService=taskService;
    }
    @PostMapping("/create/{applicationId}")
    public Task createTask(@PathVariable String applicationId, @RequestBody Task task){
        return taskService.createTask(applicationId,task);
    }
}
