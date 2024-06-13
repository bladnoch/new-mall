package senior.new_mall.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senior.new_mall.domain.post.Post;
import senior.new_mall.domain.post.PostRepository;
import senior.new_mall.dto.post.PostCreateRequest;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 개시글 저장
    public void postContent(PostCreateRequest request) {
        // db에 저장
        postRepository.save(new Post(request.getTitle(), request.getContent(), request.getMemberId()));
    }

//    // 개시글 타이틀 불러오기
//    public List<PostTitlesResponse> getTitles() {
//    }

    // 개시글 한개 불러오기
    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(IllegalAccessError::new);
    }


}
