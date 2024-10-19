package com.hubService.Repository;

import com.hubService.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,String> {
    List<Application> getByPhoneNumber(String phoneNumber);
}
