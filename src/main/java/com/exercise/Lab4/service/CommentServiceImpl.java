package com.exercise.Lab4.service;

import com.exercise.Lab4.domain.Comment;
import com.exercise.Lab4.repository.CommentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById((int)id);
    }

    @Override
    public void addComment(Comment c){
        commentRepo.save(c);
    }


}
