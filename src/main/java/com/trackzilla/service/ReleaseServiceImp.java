package com.trackzilla.service;

import com.trackzilla.data.Release;
import com.trackzilla.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseServiceImp implements ReleaseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReleaseRepository releaseR;

    public ReleaseServiceImp() {
    }

    @Override
    public List<Release> getReleaseByTicketStatus(String status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tickets.status").is(status));
        return mongoTemplate.find(query,Release.class);
    }

    @Override
    public List<Release> findAll() {
        return releaseR.findAll();
    }

    @Override
    public Optional<Release> findById(String id) {
        return releaseR.findById(id);
    }

    @Override
    public Release save(Release release) {
        return releaseR.save(release);
    }

    @Override
    public void deleteById(String id) {
        releaseR.deleteById(id);
    }

    @Override
    public void insert(Release release) {
            releaseR.insert(release);
    }
}
