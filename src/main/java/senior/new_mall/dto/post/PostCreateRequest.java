package senior.new_mall.dto.post;

import lombok.Getter;

@Getter
public class PostCreateRequest {

    public PostCreateRequest(String title, String content, Long memberId) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    private String title;
    private String content;
    private Long memberId;

}
