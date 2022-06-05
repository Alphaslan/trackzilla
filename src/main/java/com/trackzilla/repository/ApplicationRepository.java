package com.trackzilla.repository;


import com.trackzilla.data.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application,String> {

    List<Application> findByName(String name);
}
