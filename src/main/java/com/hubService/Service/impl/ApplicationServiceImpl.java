package com.hubService.Service.impl;

import com.hubService.Utility.ApplicationIdGenerator;
import com.hubService.Utility.Mapper;
import com.hubService.Model.Application;
import com.hubService.Repository.ApplicationRepository;
import com.hubService.Service.ApplicationService;
import com.hubService.Utility.Util;
import com.hubService.dto.ApplicationDTO;
import com.hubService.exception.ErrorCode;
import com.hubService.exception.GRException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }
    @Override
    public ApplicationDTO createApplication(Map<String, String> phoneNumber) {
        String applicationId = ApplicationIdGenerator.generate();
        Application application = new Application();
        application.setApplicationId(applicationId);
        Optional<String> number = Optional.ofNullable(phoneNumber.get("phoneNumber"));
        number.ifPresent(application::setPhoneNumber);
        return Mapper.modelToDTO(applicationRepository.save(application));
    }

    @Override
    public ApplicationDTO updateApplication(String applicationId, ApplicationDTO applicationDTO) {
        Application existingApplication = applicationRepository.findById(applicationId).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND));
        existingApplication.setProductRequest(applicationDTO.getProductRequest());
        existingApplication.setEmail(applicationDTO.getEmail());
        existingApplication.setFirstName(applicationDTO.getFirstName());
        existingApplication.setMiddleName(applicationDTO.getMiddleName());
        existingApplication.setLastName(applicationDTO.getLastName());
        existingApplication.setAddress(applicationDTO.getAddress());
        existingApplication.setRentOrOwn(applicationDTO.getRentOrOwn());
        existingApplication.setMonthlyHousePayment(applicationDTO.getMonthlyHousePayment());
        existingApplication.setEmploymentStatus(applicationDTO.getEmploymentStatus());
        existingApplication.setGrossAnnualIncome(applicationDTO.getGrossAnnualIncome());
        existingApplication.setIndustry(applicationDTO.getIndustry());
        existingApplication.setJobTitle(applicationDTO.getJobTitle());
        existingApplication.setEmployerName(applicationDTO.getEmployerName());
        existingApplication.setDateOfBirth(Util.localDateFormat(applicationDTO.getDateOfBirth()));
        existingApplication.setSsnNumber(applicationDTO.getSsnNumber());
        existingApplication.setSoftPullConsent(applicationDTO.getSoftPullConsent());
        return Mapper.modelToDTO(applicationRepository.save(existingApplication));
    }

    public ApplicationDTO getApplication(String appIdOrPhoneNumber){
        if(appIdOrPhoneNumber.contains("svc:grt")){
            return Mapper.modelToDTO(applicationRepository.findById(appIdOrPhoneNumber).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND)));
        }
        return Mapper.modelToDTO(applicationRepository.getByPhoneNumber(appIdOrPhoneNumber).stream().max(Comparator.comparing(Application::getCreatedAt)).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND)));
    }


}