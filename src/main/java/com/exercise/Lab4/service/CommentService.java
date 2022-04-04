package com.exercise.Lab4.service;

import com.exercise.Lab4.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    Comment findById(long id);
    void addComment(Comment comment);
//
//    void deleteComment(long id);
//
//    void update(long id, Comment comment);
//
}
