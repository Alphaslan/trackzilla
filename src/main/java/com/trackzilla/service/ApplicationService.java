package com.trackzilla.service;


import com.trackzilla.data.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {

    Application addNewApplicationWTemplate(Application application);

    Application findByIdWTemplate(String id);

    void deleteWTemplate(Application application);

    void updateApplicationNameWTemplate(String name,Application application);

    List<Application> findAll();

    Optional<Application> findById(String id);

    Application save(Application application);

    void deleteById(String id);

    List<Application> findByName(String name);

    List<Application> saveAll (List<Application> applicationList);

    void deleteAll();

    Application updateId (String id,Application application);

    Application update (String id,Application application);

}
