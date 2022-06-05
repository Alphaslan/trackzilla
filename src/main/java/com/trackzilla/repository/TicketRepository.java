package com.trackzilla.repository;

import com.trackzilla.data.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {

    List<Ticket> findByStatus(String status);

    @Query("{'status':?}")
    Stream<Ticket>findAllByCustomQuery (String status);

    List<Ticket> findByAppId(String appId);

    Ticket findByDescription(String description);
}
