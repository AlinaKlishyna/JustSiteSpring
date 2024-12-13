package com.gmail.alinakotova102.repositories;

import com.gmail.alinakotova102.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository <Message, Integer> {
}
