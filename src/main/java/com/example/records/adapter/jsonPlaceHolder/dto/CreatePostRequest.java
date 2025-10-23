package com.example.records.adapter.jsonPlaceHolder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostRequest(@NotBlank String title, @NotBlank String body, @NotNull Integer userId) {
}
