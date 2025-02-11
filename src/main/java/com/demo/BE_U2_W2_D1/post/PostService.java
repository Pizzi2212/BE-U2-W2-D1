package com.demo.BE_U2_W2_D1.post;

import com.demo.BE_U2_W2_D1.responses.CreateResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        if(!postRepository.existsById(id)){
            throw new EntityNotFoundException("Post non trovato");
        }
        return postRepository.findById(id).get();
    }
    public CreateResponse save(PostRequest request) {
        Post post = new Post();
        BeanUtils.copyProperties(request, post);
        postRepository.save(post);
        return new CreateResponse(post.getId());
    }

    public CreateResponse update(Long id, PostRequest request) {
        Post post = findById(id);
        BeanUtils.copyProperties(request, post);
        postRepository.save(post);
        return new CreateResponse(post.getId());
    }

    public void delete(Long id) {
        Post post = findById(id);
        postRepository.delete(post);
    }
}
