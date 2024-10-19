package com.hubService.Controller;

import com.hubService.Service.ApplicationService;
import com.hubService.dto.ApplicationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping("/hub")
@RestController
public class ApplicationController {
    private ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping
    public ApplicationDTO createApplication(@RequestBody Map<String, String> phoneNumber){
        return applicationService.createApplication(phoneNumber);
    }
    @PutMapping("/{applicationId}")
    public ApplicationDTO updateApplication(@PathVariable String applicationId, @RequestBody ApplicationDTO applicationDTO){
        return applicationService.updateApplication(applicationId, applicationDTO);
    }
    @GetMapping("/{appIdOrPhoneNumber}")
    public ApplicationDTO getApplicationByAppIdOrPhoneNumber(@PathVariable String appIdOrPhoneNumber){
        return applicationService.getApplication(appIdOrPhoneNumber);
    }
}