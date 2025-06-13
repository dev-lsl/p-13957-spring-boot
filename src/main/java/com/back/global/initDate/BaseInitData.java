package com.back.global.initDate;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;
    private final PostService postService;


    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return ApplicationArgumentsargs -> {

            self.work1();
            self.work2();
            self.work3();

        };
    }
    //생성
    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Post post1 = new Post("제목1", "내용1");
        postService.save(post1);

        Post post2 = new Post("제목2", "내용2");
        postService.save(post2);

        System.out.println("기본데이터가 초기화 되었습니다.");
    }
    //조회
    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost1 = postService.findById(1);

    }
    @Transactional
    void work3() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();

        postService.modify(post1, "수정 제목 1", "수정 내용 1");


    }




}
