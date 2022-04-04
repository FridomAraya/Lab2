package com.exercise.Lab4.controllers;

import com.exercise.Lab4.domain.Comment;
import com.exercise.Lab4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;


    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @PostMapping
    public void addComment(@RequestBody Comment c){
        commentService.addComment(c);
    }

}
