package senior.new_mall.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senior.new_mall.domain.post.Post;
import senior.new_mall.dto.post.PostCreateRequest;
import senior.new_mall.service.post.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 개시글 저장
    @PostMapping("/post")
    public void postContent(@RequestBody PostCreateRequest request) {
        postService.postContent(request);
    }

    // 개시글 타이틀 불러오기
    @GetMapping("/post/titles")
    public List<Post> getTitles() {
        return postService.getTitles();
    }

    // 개시글 한개 불러오기
    @GetMapping("/post/getPost")
    public Post getPost(@RequestParam Long postId) {
        return postService.getPost(postId);
    }
}
