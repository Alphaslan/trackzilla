package com.trackzilla.service;

import com.trackzilla.data.Application;
import com.trackzilla.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImp implements ApplicationService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public Application addNewApplicationWTemplate(Application application) {
        return mongoTemplate.insert(application);
    }

    @Override
    public Application findByIdWTemplate(String id) {
        return mongoTemplate.findById(id, Application.class);
    }


    @Override
    public void deleteWTemplate(Application application) {
        mongoTemplate.remove(application);
    }

    @Override
    public void updateApplicationNameWTemplate(String name, Application application) {

        //select * from Application where name=
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(application.getName()));
        Update update = new Update();
        update.set("name", name);
        mongoTemplate.updateFirst(query, update, Application.class);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> findById(String id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteById(String id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public List<Application> findByName(String name) {
        return applicationRepository.findByName(name);
    }

    @Override
    public List<Application> saveAll(List<Application> applicationList) {
        return applicationRepository.saveAll(applicationList);
    }

    @Override
    public void deleteAll() {
        applicationRepository.deleteAll();
    }

    /**
     * I wrote this method only because I wanted to show that we can change id in noSQL with no problem
     * but this usage is not recommended.
     */
    @Override
    public Application updateId(String id, Application application) {
        if (applicationRepository.findById(id).isPresent()) {
            applicationRepository.deleteById(id);
            application.setId(id);
            return applicationRepository.save(application);
        }
        return null;
    }

    @Override
    public Application update(String id, Application application) {
        if (applicationRepository.findById(id).isPresent()) {
            Application old = applicationRepository.findById(id).get();
            old.setDescription(application.getDescription());
            old.setName(application.getName());
            old.setOwner(application.getOwner());
            applicationRepository.save(old);
            return old;
        }
        return null;
    }

}