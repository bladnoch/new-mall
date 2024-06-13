package senior.new_mall.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.new_mall.domain.post.Post;
import senior.new_mall.domain.post.PostRepository;
import senior.new_mall.dto.post.PostCreateRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    // 개시글 저장
    @Transactional
    public void postContent(PostCreateRequest request) {
        // db에 저장
        postRepository.save(new Post(request.getTitle(), request.getContent(), request.getMemberId()));
    }

    // 개시글 타이틀 불러오기
    // 지금은 모든 정보를 불러오지만 필요에 따라 파라미터를 변경해 이후 수정
    public List<Post> getTitles() {

        // 나중에 필요한 정보만 사용할 때 response를 이용할 때
//        List<Post> posts = postRepository.findAll();
//        List<PostTitlesResponse> responses= new ArrayList<>();
//        for (Post post : posts) {
//            responses.add(new PostTitlesResponse(post.getId(), post.getTitle(), post.getContent(), post.getMemberId()));
//        }

        return postRepository.findAll();
    }

    // post id 기준 개시글 한개 불러오기
    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(IllegalAccessError::new);
    }


}
