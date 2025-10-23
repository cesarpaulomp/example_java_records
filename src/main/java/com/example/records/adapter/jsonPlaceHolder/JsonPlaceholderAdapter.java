package com.example.records.adapter.jsonPlaceHolder;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.records.adapter.jsonPlaceHolder.dto.CreatePostRequest;
import com.example.records.adapter.jsonPlaceHolder.dto.PostResponse;

@FeignClient(name = "jsonPlaceholderAdapter", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderAdapter {
  @GetMapping(value = "/posts", consumes = "application/json")
  List<PostResponse> getPosts(
      @RequestParam(value = "id", required = false) Long id,
      @RequestParam(value = "userId", required = false) Long userId);

  @GetMapping(value = "/posts/{id}", consumes = "application/json")
  PostResponse getPostById(@PathVariable("id") Long id);

  @PostMapping(value = "/posts", consumes = "application/json", produces = "application/json")
  PostResponse createPost(@RequestBody CreatePostRequest postRequest);
}
