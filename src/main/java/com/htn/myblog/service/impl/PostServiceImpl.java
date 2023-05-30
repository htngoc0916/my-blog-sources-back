package com.htn.myblog.service.impl;

import com.htn.myblog.dto.PostsDTO;
import com.htn.myblog.entity.Posts;
import com.htn.myblog.repository.PostsRepository;
import com.htn.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private  PostsRepository postsRepository;

    @Override
    public void savePost(Posts posts) {
        postsRepository.save(posts);
    }

    @Override
    public List<Posts> findByAllDesc() {
        return postsRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }
}
