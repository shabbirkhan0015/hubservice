package com.hubService.Service;



import com.hubService.dto.ApplicationDTO;

import java.util.Map;

public interface ApplicationService {
    public ApplicationDTO createApplication(Map<String,String> phoneNumber);
    public ApplicationDTO updateApplication(String applicationId, ApplicationDTO applicationDTO);
    public ApplicationDTO getApplication(String appIdOrPhoneNumber);
}