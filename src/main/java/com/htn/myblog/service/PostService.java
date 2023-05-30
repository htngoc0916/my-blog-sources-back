package com.htn.myblog.service;

import com.htn.myblog.entity.Posts;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Posts> findByAllDesc();
    Optional<Posts> findById(Long id);
    void savePost(Posts posts);
}
