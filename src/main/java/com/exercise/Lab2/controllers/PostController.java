package com.exercise.Lab2.controllers;

import com.exercise.Lab2.domain.Post;
import com.exercise.Lab2.dtos.PostDto;
import com.exercise.Lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    //retrieve all the posts in the database
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.findAll();
    }

    // retrieve all the posts with id 1
    @GetMapping("/{id}")
    public EntityModel<PostDto> getPostWithId(@PathVariable("id") long id){
        var postDto= postService.findById(id);

        // change the response to entity model so that we attach a link to it and return it(HATEOAS)
        EntityModel<PostDto> resource= EntityModel.of(postDto);
        //add post link your resource
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).addPost(new PostDto())).withRel("addPost"));

        //add delete link your resource
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).deletePost(id)).withRel("deletePost"));


        return resource;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  // best practice
    public PostDto addPost(@RequestBody PostDto postDto){
        postService.addPost(postDto);
        return postDto;  // has to return something for WebMvcLinkBuilder.linkTo to work well??
    }

    @ResponseStatus(HttpStatus.ACCEPTED)  // best practice
    @DeleteMapping("/{id}")
    public Post deletePost(@PathVariable("id") long id){

        postService.deletePost(id);
        return new Post();  // has to return something for WebMvcLinkBuilder.linkTo to work well ???
    }

//    @ResponseStatus(HttpStatus.ACCEPTED)  // best practice
    @PutMapping("/{id}")
    public void editPost(@PathVariable("id") long id, @RequestBody Post newPost){

        postService.update(id, newPost);
    }
}
