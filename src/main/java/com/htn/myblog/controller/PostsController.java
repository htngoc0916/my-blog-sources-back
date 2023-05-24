package com.htn.myblog.controller;

import com.htn.myblog.dto.ResponseDTO;
import com.htn.myblog.entity.Posts;
import com.htn.myblog.service.PostService;
import io.swagger.annotations.ApiModelProperty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostsController {
    @Autowired
    PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiModelProperty(value = "tat ca bai viet")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPosts() {
        List<Posts> posts = postService.findByAllDesc();
        ResponseDTO responseDTO = new ResponseDTO("OK", "Query post successfully", posts.size(), posts);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}


