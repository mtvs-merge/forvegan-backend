package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostFormDTO;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity save(PostFormDTO formDTO);
}
