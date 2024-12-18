package com.gmail.alinakotova102.repositories;

import com.gmail.alinakotova102.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository <Message, Integer> {

    List <Message> findByTag(String tag);
}
