package com.example.records.core.posts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.records.adapter.jsonPlaceHolder.JsonPlaceholderAdapter;
import com.example.records.adapter.jsonPlaceHolder.dto.CreatePostRequest;
import com.example.records.adapter.jsonPlaceHolder.dto.PostResponse;

@Service
public class PostService {
  private final JsonPlaceholderAdapter jsonPlaceholderAdapter;

  public PostService(JsonPlaceholderAdapter jsonPlaceholderAdapter) {
    this.jsonPlaceholderAdapter = jsonPlaceholderAdapter;
  }

  public PostResponse createPost(CreatePostRequest request) {
    return jsonPlaceholderAdapter.createPost(request);
  }

  public List<PostResponse> getPosts(Long id, Long userId) {
    return jsonPlaceholderAdapter.getPosts(id, userId);
  }

  public PostResponse getPostById(Long id) {
    return jsonPlaceholderAdapter.getPostById(id);
  }
}
