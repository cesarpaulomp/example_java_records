package com.example.records.core.posts.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.records.adapter.jsonPlaceHolder.dto.CreatePostRequest;
import com.example.records.adapter.jsonPlaceHolder.dto.PostResponse;
import com.example.records.core.posts.service.PostService;

@RestController
@RequestMapping(value = "/posts", produces = "application/json")
public final class PostsController {
  private final PostService postService;

  public PostsController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping(consumes = "application/json")
  public PostResponse createPost(@RequestBody @Validated CreatePostRequest request) {
    return postService.createPost(request);
  }

  @GetMapping
  public List<PostResponse> getPosts(
      @RequestParam(value = "id", required = false) Long id,
      @RequestParam(value = "userId", required = false) Long userId) {
    return postService.getPosts(id, userId);
  }

  @GetMapping("/{id}")
  public PostResponse getPostById(@PathVariable Long id) {
    return postService.getPostById(id);
  }
}
