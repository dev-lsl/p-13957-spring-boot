package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service //new를 붙이지 않아도 @Autowired를 통해서 바로 부를수있다.
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post save(Post post1) {
        return postRepository.save(post1);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
        post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);

    }
}
