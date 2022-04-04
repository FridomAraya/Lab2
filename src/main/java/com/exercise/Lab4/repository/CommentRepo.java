package com.exercise.Lab4.repository;

import com.exercise.Lab4.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment,Integer> {


    List<Comment> findAll();

    Comment findById(int id);
}
