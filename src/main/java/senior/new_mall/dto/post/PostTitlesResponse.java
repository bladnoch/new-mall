package senior.new_mall.dto.post;

public class PostTitlesResponse {

    public PostTitlesResponse(Long id, String title, String content, Long memberId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    private Long id;
    private String title;
    private String content;
    private Long memberId;

}
