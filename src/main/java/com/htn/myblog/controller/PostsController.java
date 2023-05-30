package com.htn.myblog.controller;

import com.htn.myblog.dto.PostsDTO;
import com.htn.myblog.dto.ResponseDTO;
import com.htn.myblog.entity.Posts;
import com.htn.myblog.service.PostService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.loadtime.Options;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostsController {

    @Autowired
    PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "tat ca bai viet")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPosts() {
        try{
            List<Posts> posts = postService.findByAllDesc();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDTO("OK", "Query post successfully", posts.size(), posts)
            );
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseDTO("FAILED", "Cannot find board", 0, ex)
            );
        }
    }

    @ApiOperation(value = "them bai viet")
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePost(@Valid PostsDTO postsDTO){
        try {
            Optional<Posts> postsOptional = postService.findById(postsDTO.getId());
            Posts posts = new Posts();
            if(postsOptional.isPresent()){
                //update
                posts = modelMapper.map(postsDTO, Posts.class);
                postService.savePost(posts);
            }else{
                //save
                posts = modelMapper.map(postsDTO, Posts.class);
                postService.savePost(posts);
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseDTO("OK", "Save post successfully", 0, posts)
            );
        }catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseDTO("FAILED", "Save post failed", 0, ex)
            );
        }
    }
}


