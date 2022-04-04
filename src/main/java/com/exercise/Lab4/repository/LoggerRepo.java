package com.exercise.Lab4.repository;

import com.exercise.Lab4.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {
}
