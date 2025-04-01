package com.ust.docker_ex.service;



import com.ust.docker_ex.model.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getAllPosts() {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts = restTemplate.getForObject(BASE_URL, Post[].class);
        return Arrays.asList(posts);
    }

    public Post getPostById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
    }

    public Post createPost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(BASE_URL, post, Post.class);
    }

    public void updatePost(int id, Post post) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(BASE_URL + "/" + id, post);
    }

    public void deletePost(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
